# Library Frontend + Backend + Database Deployment Activity

A compact full-stack deployment exercise containing:

- **Backend:** Spring Boot REST API (Java 21)
- **Database:** PostgreSQL
- **Database migration:** Flyway
- **Frontend:** Vite + Vanilla JavaScript
- **API base path:** `/rest`

## Project layout

```text
library-deployment-activity/
├── backend/
└── frontend/
```

## Backend environment variables

| Variable | Example | Purpose |
|---|---|---|
| `DB_URL` | `jdbc:postgresql://host:5432/librarydb?sslmode=require` | PostgreSQL JDBC URL |
| `DB_USERNAME` | `library_user` | Database user |
| `DB_PASSWORD` | `change-me` | Database password |
| `PORT` | `8080` | Backend HTTP port |
| `APP_CORS_ALLOWED_ORIGINS` | `https://your-frontend.example.com` | Allowed frontend origin(s), comma-separated |

Flyway runs automatically during backend startup. Hibernate uses `ddl-auto=validate`, so **Flyway is the schema owner**.

### Backend build and run

```bash
cd backend
mvn clean package
java -jar target/library-deployment-backend-1.0.0.jar
```

For local development, the default database configuration is:

```text
jdbc:postgresql://localhost:5432/librarydb
username: postgres
password: postgres
```

## Frontend environment variable

Create `frontend/.env` from `.env.example` and set:

```env
VITE_API_BASE_URL=https://your-backend.example.com/rest
```

For local development the default is `http://localhost:8080/rest`.

### Frontend build and run

```bash
cd frontend
npm install
npm run dev
```

Production build:

```bash
npm run build
```

Deploy the generated `dist/` directory on the frontend host.

## API endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/rest/health` | Deployment health check |
| `GET` | `/rest/books` | List books |
| `GET` | `/rest/books/{id}` | Get one book |
| `POST` | `/rest/books` | Create a book |
| `PUT` | `/rest/books/{id}` | Update a book |
| `DELETE` | `/rest/books/{id}` | Delete a book |

## Flyway migrations

- `V1__create_books_table.sql` creates the schema.
- `V2__seed_books.sql` inserts sample rows.

Do not create or modify the deployment database tables manually for this exercise; add a new versioned Flyway migration instead.
