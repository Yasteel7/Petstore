🐾 Petstore API
A RESTful API for managing pets, breeds, and more. Built with Java Spring Boot and OpenAPI, with an H2 in-memory database for testing.

🚀 Features
CRUD operations for Pets and Breeds

RESTful endpoints following OpenAPI 3.0

In-memory H2 database

Swagger UI for testing the API

🛠️ Tech Stack
Java 17+

Spring Boot

Spring Data JPA

H2 Database

OpenAPI / Swagger

Maven

## 🔐 Security

This project includes basic Spring Security configuration:

- CSRF protection is disabled (for development and Swagger testing)
- H2 database console is accessible
- Swagger UI and OpenAPI endpoints are publicly accessible
- All `/pet/**` endpoints are currently open to the public
- All other endpoints require authentication (though no authentication mechanism is implemented yet)

🚧 Note: No login or token-based authentication is currently active — security is placeholder and designed for local development and testing only.


📄 API Documentation
Swagger UI:
http://localhost:8080/swagger-ui/index.html

OpenAPI JSON:
http://localhost:8080/v3/api-docs

H2 Console (for database):
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave blank)

▶️ Getting Started
Clone the repository:

git clone https://github.com/YOUR_USERNAME/petstore-api.git
cd petstore-api

Run the app:

./mvnw spring-boot:run

Test the API in your browser or with Postman.

🧪 Sample Endpoints
GET /pets — List all pets

POST /pets — Add a new pet

GET /breeds — List all breeds

POST /breeds — Create a new breed

GET /pets/{id} — Get pet by ID

📦 Future Plans
Add customer profiles and pet ownership

Connect to a PostgreSQL or MySQL database

Add Spring Security with JWT

Add integration/unit tests

👨‍💻 Author
Yasteel Sewnarain
Teacher & Aspiring Java Developer
Email: yasteel007sewnarain@gmail.com
Portfolio: https://yasteel7.github.io
