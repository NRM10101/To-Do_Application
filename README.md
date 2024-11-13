# To-Do Microservice

A microservice for managing a simple "To-Do" application with full CRUD operations. This RESTful API interacts with a database to manage tasks.

## Features

- Create, retrieve, update, and delete tasks
- Supports listing all tasks with pagination
- RESTful API design
- Database persistence using an ORM

## Requirements

- **Programming Language**: Any language (Example: Java with Spring Boot)
- **Database**: SQL or NoSQL (Example: PostgreSQL, MongoDB)
- **ORM**: Optional, use any ORM of choice (Example: Hibernate, JPA for Java)

## Endpoints

| Method | Endpoint        | Description                               |
|--------|------------------|-------------------------------------------|
| POST   | `/tasks`        | Create a new task with title and description. |
| GET    | `/tasks/{id}`   | Retrieve details of a specific task by ID. |
| PUT    | `/tasks/{id}`   | Update a task's title or description.       |
| DELETE | `/tasks/{id}`   | Delete a task by ID.                       |
| GET    | `/tasks`        | List all tasks with pagination support.    |

## Setup

### Prerequisites

- Install your chosen programming language (e.g., Java, Python).
- Install your chosen database (e.g., PostgreSQL, MongoDB).
- Set up the necessary environment variables for database configuration.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/NRM10101/To-Do_Application.git
