# Library Management System

A comprehensive Spring Boot application for managing a library system with books, categories, members, borrowing, and fines.

## Features

- **Book Management**: Add, update, delete, and search books
- **Category Management**: Organize books by categories
- **Member Management**: Manage library members
- **Borrowing System**: Track book borrowing and returns
- **Fine Management**: Handle overdue fines
- **Pagination**: Support for paginated results
- **RESTful APIs**: Complete REST API endpoints

## Technology Stack

- **Framework**: Spring Boot 3.2.0
- **Database**: H2 (In-memory)
- **ORM**: Spring Data JPA
- **Build Tool**: Maven
- **Java Version**: 17

## API Endpoints

### Book Categories
- `GET /api/book-categories` - Get all categories
- `POST /api/book-categories` - Create new category
- `GET /api/book-categories/{id}` - Get category by ID
- `PUT /api/book-categories/{id}` - Update category
- `DELETE /api/book-categories/{id}` - Delete category
- `GET /api/book-categories/page/{page}/{size}` - Get paginated categories

### Books
- `GET /api/books` - Get all books
- `POST /api/books` - Create new book
- `GET /api/books/{id}` - Get book by ID
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book
- `GET /api/books/category/{categoryName}` - Get books by category
- `GET /api/books/title/{title}` - Get books by title

### Members
- `GET /api/members` - Get all members
- `POST /api/members` - Create new member
- `GET /api/members/{id}` - Get member by ID
- `PUT /api/members/{id}` - Update member
- `DELETE /api/members/{id}` - Delete member
- `GET /api/members/phone/{phone}` - Get members by phone
- `GET /api/members/email/{email}` - Get members by email

### Borrows
- `GET /api/borrows` - Get all borrows
- `POST /api/borrows` - Create new borrow
- `GET /api/borrows/{id}` - Get borrow by ID
- `PUT /api/borrows/{id}` - Update borrow
- `DELETE /api/borrows/{id}` - Delete borrow

### Fines
- `GET /api/fines` - Get all fines
- `POST /api/fines` - Create new fine
- `GET /api/fines/{id}` - Get fine by ID
- `PUT /api/fines/{id}` - Update fine
- `DELETE /api/fines/{id}` - Delete fine

## Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. Access H2 Console: `http://localhost:8080/h2-console`

## Testing

Run all tests: `mvn test`

The project includes 80 comprehensive test cases covering:
- Directory structure validation
- Model annotations and relationships
- Repository functionality
- Controller mappings and endpoints
- Service layer implementation
- Integration testing
- Exception handling
- AOP configuration

## Project Structure

```
src/
├── main/
│   ├── java/com/examly/springapp/
│   │   ├── controller/     # REST Controllers
│   │   ├── model/          # JPA Entities
│   │   ├── repository/     # Data Access Layer
│   │   ├── service/        # Business Logic Layer
│   │   ├── exception/      # Exception Handling
│   │   ├── configuration/  # Configuration Classes
│   │   └── aop/           # Aspect-Oriented Programming
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/examly/springapp/
        └── SpringappApplicationTests.java
```

## Author

- **Name**: Siddharth
- **Email**: 727724euit251@skcet.ac.in
- **Username**: siddharth341