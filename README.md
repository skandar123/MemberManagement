<<<<<<< HEAD
# Member Management System (MMS)

### 📌 Overview

The Member Management System is a Spring Boot web application designed to manage members of an organization.
It provides CRUD functionality for managing members and includes REST APIs for querying by first name and phone number.

The project follows a layered architecture:

Controller – handles web requests

Service – contains business logic

Repository – interacts with the database using Spring Data JPA

Entity – models the data

Exception handling and validation are included to ensure data integrity and user-friendly error responses.

### 🚀 Features

1. Create, update, list, and delete members
2. Search members by first name or phone number
3. Validation with jakarta.validation annotations (@NotBlank)
4. Global exception handling with custom error messages
5. Logging with SLF4J
6. Unit and integration tests (Controller, Service, Repository)

### 🏗️ Project Structure

    com.mms
    │── MmsApplication.java
    │
    ├── controller/
    │   └── MemberController.java
    ├── entity/
    │   ├── Member.java
    │   └── ErrorMessage.java
    ├── exception/
    │   ├── MemberNotFoundException.java
    │   └── RestResponseEntityExceptionHandler.java
    ├── impl/
    │   └── MemberServiceImpl.java
    ├── repository/
    │   └── MemberRepository.java
    ├── service/
    │   └── MemberService.java
    └── tests/
    ├── MemberControllerTest.java
    ├── MemberServiceTest.java
    ├── MemberRepositoryTest.java

### ⚙️ Technologies Used

1. Java 17+
2. Spring Boot 3.x
3. Spring Data JPA
4. Hibernate
5. H2 / MySQL (configurable)
6. Lombok
7. JUnit 5 + Mockito for testing

### ▶️ Running the Application
**Clone the repository**

       git clone https://github.com/your-repo/mms.git
    
       cd mms

**Build the project**

       mvn clean install

**Run the application**
   
    mvn spring-boot:run


The application will start on http://localhost:8080

### 🌐 API Endpoints

| Method | Endpoint                         | Description                       |
| ------ | -------------------------------- | --------------------------------- |
| GET    | `/members`                       | List all members (web page view)  |
| GET    | `/members/new`                   | Form to create a new member       |
| POST   | `/members`                       | Save a new member                 |
| GET    | `/members/edit/{id}`             | Edit an existing member           |
| POST   | `/members/{id}`                  | Update member by ID               |
| GET    | `/members/{id}`                  | Delete member by ID               |
| GET    | `/members/firstname/{firstname}` | Get members by first name (JSON)  |
| GET    | `/members/phone/{phone}`         | Get member by phone number (JSON) |

### ⚙️ Example 
application.properties

#### 🔹 Option 1: H2 (In-Memory Database – easiest to run)

    # H2 Database (in-memory)
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driver-class-name=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=

    # JPA & Hibernate
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.jpa.hibernate.ddl-auto=update
    
    # H2 Console
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    
    # Logging
    logging.level.org.springframework=INFO


Access H2 Console at: http://localhost:8080/h2-console

(JDBC URL: jdbc:h2:mem:testdb, username: sa, no password)

#### 🔹 **Option 2: MySQL (persistent database)**
    
    # MySQL Database
        spring.datasource.url=jdbc:mysql://localhost:3306/mmsdb
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.username=root
        spring.datasource.password=yourpassword
    
    # JPA & Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    
    # Logging
    logging.level.org.springframework=INFO


⚠️ Ensure you have created the database in MySQL:

    CREATE DATABASE mmsdb;

### 🧪 Testing

The project includes comprehensive tests:

#### Controller Tests (MemberControllerTest)

* Validate endpoints with MockMvc
* Ensure form submission, redirections, and model attributes

#### Service Tests (MemberServiceTest)

* Use Mockito to mock the repository
* Verify business logic for searching by first name and phone

#### Repository Tests (MemberRepositoryTest)

* Use @DataJpaTest with TestEntityManager
* Validate persistence and query methods

**Run all tests:**

    mvn test

### 👩‍💻 Author

Sayantika Kandar
=======
# MemberManagement
Application to manage members using Java, SpringBoot, Hibernate, MySQL, HTML, Bootstrap, Thymeleaf, Maven
>>>>>>> 37cf5fc4c654983733bcd779855e96245cecd4da
