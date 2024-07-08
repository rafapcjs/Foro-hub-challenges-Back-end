Spring Boot MySQL JWT Spring Security OpenAPI
Overview
This project is a sample implementation using Spring Boot, MySQL for data persistence, JWT (JSON Web Tokens) for authentication, Spring Security for securing endpoints, and OpenAPI (Swagger) for API documentation.

Technologies Used
Spring Boot: Framework for creating standalone, production-grade Spring-based applications.
MySQL: Relational database used for data storage and retrieval.
JWT (JSON Web Tokens): Used for secure authentication between parties.
Spring Security: Provides authentication, authorization, and protection against common vulnerabilities.
OpenAPI (Swagger): API documentation and design tools for developers and teams.
Prerequisites
JDK 8 or higher installed
Maven or Gradle build tool installed
MySQL server installed and running
IDE (IntelliJ IDEA, Eclipse, etc.) with Spring Boot support
Setup Instructions
Clone the repository:

bash
Copiar código
git clone https://github.com/your/repository.git
cd repository
Database Configuration:

Create a MySQL database named your_database_name.
Update application.properties or application.yml with your MySQL database configuration:
yaml
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the Application:

Using Maven:
bash
Copiar código
mvn spring-boot:run
Using Gradle:
bash
Copiar código
./gradlew bootRun
Testing the APIs:

Once the application is running, you can access the Swagger UI for API documentation and testing:
bash
Copiar código
http://localhost:8080/swagger-ui.html
Endpoints
POST /login: Authenticates a user and returns a JWT token.
POST /topicos: Creates a new topic.
GET /topicos: Retrieves a list of topics.
GET /topicos/{id}: Retrieves details of a specific topic by ID.
PUT /topicos: Updates information of a topic.
DELETE /topicos/{id}: Deletes a topic by ID.
Security
