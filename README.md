# REST With Spring Boot

## 1. Stack

### Spring Boot
* Spring Boot 2.2.4
* Spring Boot Web Starter
* Spring Boot Security Starter
* Spring Boot JPA Starter
* Spring Boot Maven Plugin

### Persistence
* H2 (embedded)

### Front-End
* Thymeleaf
* Bootstrap

## 2. Requirements
* JDK 11
* Maven

## 3. Set-Up
1. Run a `mvn clean install` to resolve any dependencies for the project.
2. Import the project into your IDE of choice.
3. Edit the run configurations to run the application from `DemoApplication.class`
    1. If using Environment variables for run configurations, add them now.
4. If not using Environment variables for configurations, verify them in 
`application.properties` or `application.yaml`.
5. Ensure `data.sql` creates the tables you want it to.
    1. Change `spring.datasource.url` in `application.yaml` (if using static configuration files), or `jdbc.url`
    (if using environment variables) to the appropriate database. **Note:** ensure the url is set to the correct 
    *absolute* path.
 
## 4. Package Structure
* `com.example.demo.dto` contains a generic DTO which is being used to send responses
back to the client.
* `com.example.demo.entity` is for persistence related entities and attributes (i.e. addresses and customers)
* `com.example.demo.repos` contains an interface containing JPA-related method signatures
* `com.example.demo.rest` is related to the REST service
    * `com.example.demo.rest.controller` contains the REST controller which exposes its methods as HTTP endpoints
    * `com.example.demo.rest.service` contains the service class which handles the business logic handed off by the 
    controller.
* `com.example.demo.util` contains some utility classes for both configurations and REST logic.
* `resources` contains static configuration information, including a YAML-based configuration for Spring Boot and
a SQL file specifying a schema for H2.