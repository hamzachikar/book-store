# book-store

[![CI/CD](https://github.com/hamzachikar/book-store/workflows/book-store-CI/badge.svg)](https://github.com/hamzachikar/book-store/actions)

## General info
this is a project for creating a book-store API 

# Guidelines
#### Before you commit
 - Check build is passing (mvn clean package) locally
 - Unit tests written and passing
 - Code is well formatted
 - SonarLint run against code
 - Findbugs run againt code
 - Integration Tests written and passing

#### workflow
 - always create dedicated branches for new developement
 - to merge with master create a PR and make the other team members as reviewers
   
## Requirements
  For building and running the application you need:
    * JDK 13
    * Maven 4

## Running the application locally
  There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentric.springbootsample.Application class    from your IDE.
Alternatively you can use the Spring Boot Maven plugin like so:
```
mvn spring-boot:run
````
## Technologies used in this project
  In this project we used different type of technologies:  
   * Java 13
   * Spring Boot 2.4
   * In-memory database (H2) to store the data.
   * Swagger 2 for testing API
   * Lombok
   * Maven-checkstyle plugin
   * Maven-javadoc
   * Log4j2
   * AssertJ
   * SonarCloud

## About Book-store project:
  ### Features:
   In this Spring boot application we can manage books in a store by:
    * Add, update,find or delete a book
    * Add comments to a book


