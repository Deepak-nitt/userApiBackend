# Spring Boot REST API for User Management

This is a Spring Boot REST API application to manage **students** with CRUD operations and validations.


## Project Overview

This project provides a simple RESTful API to manage users (students). Each student has the following attributes:

- `id` (Long) – Auto-generated unique identifier
- `name` (String) – Student's name (required)
- `grade` (int) – Student’s grade (1–12)

The API supports:

- Create a new student
- Read all students / single student by ID
- Update student details
- Delete a student

---

## Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA (optional)
- Maven
- Postman (for testing)

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- IDE: IntelliJ IDEA
- Postman or any API client

### Run the Project

```bash
# Clone repository
git clone <repository-url>
cd <project-folder>

# Run project
mvn spring-boot:run
