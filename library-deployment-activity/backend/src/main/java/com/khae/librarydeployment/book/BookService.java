package com.khae.librarydeployment.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
    }

    public Book create(BookRequest request) {
        String isbn = request.isbn().trim();
        if (repository.existsByIsbnIgnoreCase(isbn)) {
            throw new DuplicateResourceException("ISBN already exists: " + isbn);
        }
        Book book = new Book(
                request.title().trim(),
                request.author().trim(),
                isbn,
                request.availableCopies());
        return repository.save(book);
    }

    public Book update(Long id, BookRequest request) {
        Book book = findById(id);
        String isbn = request.isbn().trim();
        if (repository.existsByIsbnIgnoreCaseAndIdNot(isbn, id)) {
            throw new DuplicateResourceException("ISBN already exists: " + isbn);
        }
        book.update(
                request.title().trim(),
                request.author().trim(),
                isbn,
                request.availableCopies());
        return book;
    }

    public void delete(Long id) {
        Book book = findById(id);
        repository.delete(book);
    }
}
