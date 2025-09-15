# Spring Security with JWT – Demo Project

This is a simple **Spring Boot** project demonstrating the integration of **Spring Security** with **JWT (JSON Web Token)** authentication. It also includes a minimal **REST API** to validate JWTs and showcase how secured endpoints work.

---

## 🚀 Features

* Spring Boot application
* Spring Security integration
* JWT-based authentication and authorization
* Simple REST API endpoints to test JWT validation
* PostgreSQL database integration

---

## 📂 Project Setup

### 1. Clone the Repository

```bash
git clone https://github.com/brijkishor365/spring-security-with-jwt.git
cd spring-security-with-jwt
```

### 2. Open the Project

You can open the project in **IntelliJ IDEA** or **VS Code**.

### 3. Build the Project

Use **Maven** to build the project:

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

By default, the application will run on:

```
http://localhost:8080
```

---

## 🛠️ Requirements

* **Java 17+** (or compatible version)
* **Maven 3.8+**
* **PostgreSQL** installed and running locally

---

## 🗄️ Database Setup

1. Install **PostgreSQL** on your local machine.
2. Create a new database (e.g., `jwt_demo_db`):

   ```sql
   CREATE DATABASE jwt_demo_db;
   ```
3. Update your database configuration inside `application.properties` (or `application.yml`):

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/jwt_demo_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

---

## 📬 Testing the API

You can use **Postman** (or any REST client) to test the endpoints:

### 1. Register a New User

```
POST http://localhost:8080/register
```

Body (JSON):

```json
{
  "username": "testuser",
  "password": "password123"
}
```

### 2. Authenticate and Get JWT

```
POST http://localhost:8080/login
```

Body (JSON):

```json
{
  "username": "testuser",
  "password": "password123"
}
```

Response (sample):

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}
```

### 3. Access Secured Endpoint

```
GET http://localhost:8080/students
```

Headers:

```
Authorization: Bearer <your-jwt-token>
```

Response (sample):

```json
{
  "message": "Hello, you have accessed a secured endpoint!"
}
```

---

## 📖 Notes

* Ensure PostgreSQL is running before starting the project.
* Replace `your_username` and `your_password` in the `application.properties` file with your local database credentials.
* If you prefer, you can switch to another database (like H2/MySQL) by updating the dependencies and configuration.

---

## 📌 Tech Stack

* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Token)**
* **PostgreSQL**
* **Maven**

>### More upgrades: 
https://www.geeksforgeeks.org/springboot/spring-boot-3-0-jwt-authentication-with-spring-security-using-mysql-database/
