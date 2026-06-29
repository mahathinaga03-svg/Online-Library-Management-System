# Online Library Management System - Integrated Full Stack Project

This ZIP contains both frontend and backend code integrated using REST APIs.

## Frontend
Folder: `frontend`
Technologies: HTML, CSS, JavaScript

Open `frontend/index.html` in a browser.

## Backend
Folder: `backend`
Technologies: Java, Spring Boot, MySQL, REST API

### Steps to Run Backend
1. Install Java 17, Maven, and MySQL.
2. Open `backend/src/main/resources/application.properties`.
3. Change `spring.datasource.password=your_password` to your MySQL password.
4. Open terminal inside the `backend` folder.
5. Run:
   `mvn spring-boot:run`

## Integration
The frontend connects to backend API using:
`http://localhost:8080/api`

Features included:
- User registration
- Simple login
- Add and view books
- Issue book
- Return book
- Fine calculation
