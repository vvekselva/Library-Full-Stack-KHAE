const API_BASE = (import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/rest').replace(/\/$/, '');

const apiBaseElement = document.querySelector('#api-base');
const backendStatus = document.querySelector('#backend-status');
const rows = document.querySelector('#book-rows');
const form = document.querySelector('#book-form');
const message = document.querySelector('#message');
const formTitle = document.querySelector('#form-title');
const cancelButton = document.querySelector('#cancel-button');
const refreshButton = document.querySelector('#refresh-button');

apiBaseElement.textContent = API_BASE;

async function request(path, options = {}) {
  const response = await fetch(`${API_BASE}${path}`, {
    ...options,
    headers: {
      'Content-Type': 'application/json',
      ...(options.headers || {})
    }
  });

  if (!response.ok) {
    let errorMessage = `${response.status} ${response.statusText}`;
    try {
      const body = await response.json();
      errorMessage = body.message || errorMessage;
    } catch (_) {
      // Keep the HTTP status message when no JSON error body is available.
    }
    throw new Error(errorMessage);
  }

  if (response.status === 204) return null;
  return response.json();
}

async function checkBackend() {
  try {
    const health = await request('/health');
    backendStatus.textContent = `Backend: ${health.status} | Database: ${health.database}`;
    backendStatus.className = 'status up';
  } catch (error) {
    backendStatus.textContent = `Backend unavailable: ${error.message}`;
    backendStatus.className = 'status down';
  }
}

async function loadBooks() {
  rows.innerHTML = '<tr><td colspan="6">Loading…</td></tr>';
  try {
    const books = await request('/books');
    if (books.length === 0) {
      rows.innerHTML = '<tr><td colspan="6">No books found.</td></tr>';
      return;
    }

    rows.innerHTML = '';
    for (const book of books) {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${book.id}</td>
        <td>${escapeHtml(book.title)}</td>
        <td>${escapeHtml(book.author)}</td>
        <td>${escapeHtml(book.isbn)}</td>
        <td>${book.availableCopies}</td>
        <td class="row-actions">
          <button class="small edit">Edit</button>
          <button class="small danger delete">Delete</button>
        </td>`;
      tr.querySelector('.edit').addEventListener('click', () => beginEdit(book));
      tr.querySelector('.delete').addEventListener('click', () => deleteBook(book));
      rows.appendChild(tr);
    }
  } catch (error) {
    rows.innerHTML = `<tr><td colspan="6" class="error-cell">${escapeHtml(error.message)}</td></tr>`;
  }
}

function beginEdit(book) {
  document.querySelector('#book-id').value = book.id;
  document.querySelector('#title').value = book.title;
  document.querySelector('#author').value = book.author;
  document.querySelector('#isbn').value = book.isbn;
  document.querySelector('#availableCopies').value = book.availableCopies;
  formTitle.textContent = `Edit Book #${book.id}`;
  cancelButton.hidden = false;
  message.textContent = '';
  window.scrollTo({ top: 0, behavior: 'smooth' });
}

function resetForm() {
  form.reset();
  document.querySelector('#book-id').value = '';
  document.querySelector('#availableCopies').value = 1;
  formTitle.textContent = 'Add Book';
  cancelButton.hidden = true;
}

form.addEventListener('submit', async (event) => {
  event.preventDefault();
  message.textContent = '';

  const id = document.querySelector('#book-id').value;
  const payload = {
    title: document.querySelector('#title').value,
    author: document.querySelector('#author').value,
    isbn: document.querySelector('#isbn').value,
    availableCopies: Number(document.querySelector('#availableCopies').value)
  };

  try {
    if (id) {
      await request(`/books/${id}`, { method: 'PUT', body: JSON.stringify(payload) });
      message.textContent = 'Book updated successfully.';
    } else {
      await request('/books', { method: 'POST', body: JSON.stringify(payload) });
      message.textContent = 'Book created successfully.';
    }
    resetForm();
    await loadBooks();
  } catch (error) {
    message.textContent = error.message;
  }
});

async function deleteBook(book) {
  if (!window.confirm(`Delete "${book.title}"?`)) return;
  try {
    await request(`/books/${book.id}`, { method: 'DELETE' });
    message.textContent = 'Book deleted successfully.';
    await loadBooks();
  } catch (error) {
    message.textContent = error.message;
  }
}

function escapeHtml(value) {
  return String(value)
    .replaceAll('&', '&amp;')
    .replaceAll('<', '&lt;')
    .replaceAll('>', '&gt;')
    .replaceAll('"', '&quot;')
    .replaceAll("'", '&#039;');
}

cancelButton.addEventListener('click', resetForm);
refreshButton.addEventListener('click', loadBooks);

async function initializeApp() {
  await checkBackend();
  await loadBooks();
}

initializeApp();
