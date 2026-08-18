# Library Management Application - Launch Guide

**Repository:** `vvekselva/Library-Full-Stack-KHAE-Master`  
**Branch:** `FrontEnd-Backend-DB-Deployment`  
**Application folder:** `library-deployment-activity/`  
**Stack:** Vite Frontend + Spring Boot Backend + PostgreSQL + Flyway + Docker  
**API base path:** `/rest`

## 1. Purpose

This guide explains how to launch the Library deployment activity, verify PostgreSQL and Flyway migration, check backend connectivity, and verify the frontend CRUD operations.

The runtime flow is:

```text
Browser / Vite Frontend
        |
        v
Spring Boot REST API
        |
        v
PostgreSQL
        ^
        |
Flyway V1 schema -> Flyway V2 sample data -> Hibernate validation
```

## 2. Prerequisites

### Recommended Docker launch

Install Docker Desktop or Docker Engine with Docker Compose support. Docker Compose starts PostgreSQL, the Spring Boot backend, and the frontend together.

### Manual launch

Install:

- Java 21
- Maven
- PostgreSQL
- Node.js and npm

## 3. Recommended Launch - Docker Compose

### Step 1 - Open the deployment activity folder

```bash
cd library-deployment-activity
```

### Step 2 - Create the Docker environment file

Windows Command Prompt:

```bat
copy .env.docker.example .env
```

PowerShell:

```powershell
Copy-Item .env.docker.example .env
```

Linux / macOS:

```bash
cp .env.docker.example .env
```

### Step 3 - Review the environment configuration

The example values are:

```env
POSTGRES_DB=librarydb
POSTGRES_USER=library_user
POSTGRES_PASSWORD=change-this-password
APP_CORS_ALLOWED_ORIGINS=http://localhost:8081
VITE_API_BASE_URL=http://localhost:8080/rest
```

Change the sample PostgreSQL password for a real environment. Do not commit real passwords to Git.

### Step 4 - Build and start the complete application

```bash
docker compose up --build
```

Keep this terminal open. During the first startup you should see:

1. PostgreSQL starts and becomes healthy.
2. Spring Boot starts.
3. Flyway connects to PostgreSQL.
4. `V1__create_books_table.sql` creates the `books` table.
5. `V2__seed_books.sql` inserts sample book data.
6. Hibernate validates the migrated schema.
7. The REST API becomes available.
8. The frontend calls the backend API.

## 4. URLs to Verify

| Purpose | URL | Expected result |
|---|---|---|
| Frontend | `http://localhost:8081` | Library Management page |
| Backend health | `http://localhost:8080/rest/health` | JSON with backend `UP` and database `UP` |
| Books API | `http://localhost:8080/rest/books` | JSON array containing sample books |

## 5. Verify PostgreSQL and Flyway

Flyway is the database schema owner. On a fresh PostgreSQL database, migrations run in version order.

```text
V1__create_books_table.sql
        |
        v
Creates books table
        |
        v
V2__seed_books.sql
        |
        v
Inserts sample books
        |
        v
Hibernate ddl-auto=validate
```

Open PostgreSQL inside the running database container:

```bash
docker compose exec db psql -U library_user -d librarydb
```

Inside `psql`, verify the tables:

```sql
\dt
```

Verify the Flyway migration history:

```sql
SELECT *
FROM flyway_schema_history
ORDER BY installed_rank;
```

Verify the book data:

```sql
SELECT id, title, author, isbn, available_copies
FROM books
ORDER BY id;
```

Exit PostgreSQL:

```text
\q
```

## 6. Verify the Frontend CRUD Flow

1. Open `http://localhost:8081`.
2. Confirm the status shows `Backend: UP` and `Database: UP`.
3. Confirm the sample books inserted by Flyway V2 are listed.
4. Create a new book using Title, Author, ISBN, and Available Copies.
5. Edit an existing book and save the changes.
6. Delete a book and confirm the action.
7. Click Refresh and confirm the current PostgreSQL data is displayed.

## 7. Alternative Launch - Without Docker

Use this method when PostgreSQL is already installed and each deployment layer must be shown separately.

### Step 1 - Prepare PostgreSQL

Create the `librarydb` database and provide credentials. A hosted PostgreSQL instance can also be used by changing `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`.

### Step 2 - Set backend environment variables

PowerShell example:

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/librarydb"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="postgres"
$env:APP_CORS_ALLOWED_ORIGINS="http://localhost:5173"
```

### Step 3 - Build and launch the backend

```bash
cd backend
mvn clean package
java -jar target/library-deployment-backend-1.0.0.jar
```

When Spring Boot starts, Flyway automatically executes the migration scripts against the configured PostgreSQL database.

### Step 4 - Configure and launch the frontend

Open another terminal:

```bat
cd frontend
copy .env.example .env
npm install
npm run dev
```

Open the URL shown by Vite, normally `http://localhost:5173`.

## 8. Stop, Restart, and Reset Docker

Stop the containers while keeping PostgreSQL data:

```bash
docker compose down
```

Restart with the existing PostgreSQL volume:

```bash
docker compose up
```

For a completely fresh migration demonstration, remove the PostgreSQL volume:

```bash
docker compose down -v
docker compose up --build
```

`docker compose down -v` removes the persisted PostgreSQL volume. The next startup behaves like a new database environment, so Flyway runs V1 and V2 again.

## 9. Common Launch Problems

| Problem | Likely reason | Action |
|---|---|---|
| Frontend reports backend unavailable | Backend is not ready, API URL is wrong, or CORS does not match | Open `/rest/health`, check `docker compose logs backend`, and verify `VITE_API_BASE_URL` and `APP_CORS_ALLOWED_ORIGINS` |
| Backend cannot connect to database | Incorrect DB URL/user/password, PostgreSQL not ready, or host is wrong | In Docker Compose use host `db`, not `localhost`, from the backend container; check `docker compose logs db` |
| Flyway migration fails | SQL migration error or existing conflicting objects | Read backend logs and inspect `flyway_schema_history`; do not manually change migration history |
| Port already in use | Another application uses 5432, 8080, or 8081 | Stop the conflicting process or change the host port mapping |
| Frontend uses an old backend URL | Vite variables are embedded at build time | Rebuild the frontend image after changing `VITE_API_BASE_URL` |
| Data remains after restart | PostgreSQL Docker volume is persistent | Use `docker compose down -v` only when a full reset is intended |

## 10. Suggested Classroom Demonstration Sequence

1. Show the `library-deployment-activity/` folder structure.
2. Identify the frontend, backend, Flyway migrations, Dockerfiles, and `docker-compose.yml`.
3. Show `.env.docker.example` and explain environment-specific configuration.
4. Run `docker compose up --build`.
5. Show PostgreSQL becoming healthy.
6. Show the backend starting.
7. Point out Flyway V1 and V2 execution in backend logs.
8. Open `/rest/health` and confirm the database is UP.
9. Open `/rest/books` and show the backend JSON response.
10. Open the frontend and perform Create, Edit, Delete, and Refresh.
11. Run `docker compose down` and explain persistence.
12. Run `docker compose down -v` and relaunch to demonstrate a fresh Flyway migration.

## 11. Deployment Completion Checklist

- [ ] PostgreSQL started successfully.
- [ ] Flyway V1 and V2 completed successfully.
- [ ] Backend health returns `UP`.
- [ ] Database status returns `UP`.
- [ ] `GET /rest/books` returns sample books.
- [ ] Frontend loads successfully.
- [ ] Frontend displays the configured API base URL.
- [ ] Create Book works.
- [ ] Edit Book works.
- [ ] Delete Book works.
- [ ] Data survives a normal `docker compose down` / `docker compose up` restart.
- [ ] A full reset with `docker compose down -v` causes Flyway to rebuild the database.

The deployment is complete when the frontend, backend, and PostgreSQL communicate successfully and the database schema is reproducibly created by Flyway instead of by manual SQL changes.
