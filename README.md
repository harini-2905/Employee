# 🚀 Spring Boot Employee Management REST API

A simple yet powerful **Employee Management REST API** built using **Spring Boot** 💻.
This project helps manage employee records through clean and structured RESTful endpoints.

✨ Developed as part of learning backend development with Spring Boot.

## 🌟 Features

✅ Create a new employee
✅ Retrieve all employees
✅ Retrieve employee by ID
✅ Update employee details
✅ Delete employee records
✅ Pagination support 📄
✅ Input validation ✔️
✅ PostgreSQL database integration 🐘

## 🛠️ Technologies Used

* ☕ Java
* 🌱 Spring Boot
* 🐘 PostgreSQL
* 📦 Maven
* 🔗 REST APIs
* 🧪 Postman (for testing)

## 🧱 Project Architecture

The project follows a clean **layered architecture**:

```
Controller → Service → Repository → Model
```

🔹 **Controller** – Handles API requests and responses
🔹 **Service** – Contains business logic
🔹 **Repository** – Communicates with the database
🔹 **Model** – Represents the Employee entity

## 🔗 API Endpoints

| Method | Endpoint        | Description        |
| ------ | --------------- | ------------------ |
| POST   | /employees      | Create employee    |
| GET    | /employees      | Get all employees  |
| GET    | /employees/{id} | Get employee by ID |
| PUT    | /employees/{id} | Update employee    |
| DELETE | /employees/{id} | Delete employee    |

## 📄 Pagination Example

To fetch employees in smaller chunks:

```
GET /employees?page=0&size=5
```

💡 Helps improve performance by avoiding loading all data at once.

## 🔐 Validation

The API ensures data correctness using validation annotations:

* `@NotBlank` ✏️
* `@NotNull` ⚠️
* `@Email` 📧

🛡️ This guarantees that only valid employee data is stored.

## 🎯 Key Highlights

✨ Clean and maintainable architecture
✨ Beginner-friendly project
✨ Real-world backend development concepts
✨ Easy to extend and scale

