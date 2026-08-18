# Library Frontend + Backend + Database Deployment Activity

A compact full-stack deployment exercise containing:

- **Backend:** Spring Boot REST API (Java 21)
- **Database:** PostgreSQL
- **Database migration:** Flyway
- **Frontend:** Vite + Vanilla JavaScript
- **Container deployment:** Docker + Docker Compose
- **CI/CD:** GitHub Actions + GitHub Container Registry (GHCR)
- **API base path:** `/rest`

## Project layout

```text
library-deployment-activity/
├── backend/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
├── frontend/
│   ├── Dockerfile
│   ├── nginx.conf
│   └── src/
├── .env.docker.example
└── docker-compose.yml
```

The CI/CD workflow is stored at:

```text
.github/workflows/library-deployment-ci-cd.yml
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

### Backend build and run without Docker

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

### Frontend build and run without Docker

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

## Run the complete application with Docker Compose

From `library-deployment-activity/`:

```bash
cp .env.docker.example .env
```

Change the database password in `.env`, then run:

```bash
docker compose up --build
```

Open:

- Frontend: `http://localhost:8081`
- Backend health: `http://localhost:8080/rest/health`
- Backend books API: `http://localhost:8080/rest/books`
- PostgreSQL host port: `5432`

The startup sequence is:

```text
PostgreSQL becomes healthy
        ↓
Spring Boot starts
        ↓
Flyway V1 creates books table
        ↓
Flyway V2 inserts sample books
        ↓
Hibernate validates the migrated schema
        ↓
Frontend calls /rest/health and /rest/books
```

Stop the containers:

```bash
docker compose down
```

Remove the containers and the PostgreSQL volume when a completely fresh migration demonstration is required:

```bash
docker compose down -v
```

## Build Docker images individually

Backend:

```bash
docker build -t your-registry/library-backend:1.0 ./backend
docker push your-registry/library-backend:1.0
```

Frontend:

```bash
docker build \
  --build-arg VITE_API_BASE_URL=https://your-backend.example.com/rest \
  -t your-registry/library-frontend:1.0 ./frontend

docker push your-registry/library-frontend:1.0
```

`VITE_API_BASE_URL` is a Vite build-time variable. When the backend URL changes, rebuild the frontend image with the new URL.

## GitHub Actions CI/CD

The workflow runs automatically when deployment application files are pushed to `FrontEnd-Backend-DB-Deployment`. It can also be started manually from the **Actions** tab using **Run workflow**.

### Continuous Integration gates

1. **Backend CI + PostgreSQL + Flyway**
   - Starts PostgreSQL 16 as a GitHub Actions service container.
   - Builds and verifies the Spring Boot application with Maven and Java 21.
   - Starts the packaged backend.
   - Calls `/rest/health`.
   - Calls `/rest/books` and confirms Flyway seed data is available.

2. **Frontend CI**
   - Uses Node.js 20.
   - Installs the frontend dependencies.
   - Builds the Vite production bundle.
   - Uploads `dist/` as a workflow artifact.

3. **Docker Build Validation**
   - Builds the backend Docker image.
   - Builds the frontend Docker image.
   - Does not publish anything unless both application CI jobs have succeeded.

### Continuous Delivery

After all CI gates succeed on a push to `FrontEnd-Backend-DB-Deployment`, the workflow publishes these images to GitHub Container Registry:

```text
ghcr.io/vvekselva/library-deployment-backend:latest
ghcr.io/vvekselva/library-deployment-frontend:latest
```

Each image also receives an immutable commit-based tag such as:

```text
sha-1a2b3c4
```

No separate registry password is required. The workflow authenticates to GHCR using the repository-provided `GITHUB_TOKEN` with `packages: write` permission.

### Required repository variable for a deployed frontend

The frontend API URL is embedded during the Vite build. Before using the published frontend image in a real hosted environment, create this GitHub Actions repository variable:

```text
Name:  VITE_API_BASE_URL
Value: https://your-backend-host/rest
```

GitHub path:

```text
Repository -> Settings -> Secrets and variables -> Actions -> Variables -> New repository variable
```

If this variable is not configured, the workflow uses `http://localhost:8080/rest`, which is suitable only for the local deployment demonstration.

## API endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/rest/health` | Backend + database deployment health check |
| `GET` | `/rest/books` | List books |
| `GET` | `/rest/books/{id}` | Get one book |
| `POST` | `/rest/books` | Create a book |
| `PUT` | `/rest/books/{id}` | Update a book |
| `DELETE` | `/rest/books/{id}` | Delete a book |

## Flyway migrations

- `V1__create_books_table.sql` creates the schema.
- `V2__seed_books.sql` inserts sample rows.

Do not create or modify deployment database tables manually for this exercise. Add a new versioned Flyway migration instead so every environment receives the same database changes.
