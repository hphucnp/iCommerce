# I-COMMERCE Quick Start

### Explanation
 To whom it may concern, the development here is about microservice architecture where it is small service with minimum 
 dependencies and simple configuration. I follow SOLID principles to some extent, especially Interface Segregation.
Design patterns: (based on Spring Boot) Singletons (one bean at a time within Spring IoC container), Autowired Singletons,
 Factory Method, Transactions, External Configuration, Application Context, Jdbc Template, Proxy Pattern
 So, I use framework Spring Boot to implement CRUD operations along with build tool Maven, 
 java 11, Swagger UI for RESTful API documentation. Main java libraries are JPA, querydsl, lombok (for auto-generating setters and getters) , springdoc-openapi-ui, 
 spring-boot-starter-test, postgresql, jdbc, springboot web.
  
 
 There are 4 layers:
- config: contains application configuration ( run, build and api documentation)
- api: contains controllers (similar controller in MVC) as well as responses and requests and related mappers
- business: services and their implementation (Dependency Injection) handle business logic , Querydsl is used as a tool 
  to easily generate SQL queries
- data: persistence layer using JPA (entity and repository with/o paging), JDBC (connect to postgres)


### Steps to run the application (without docker) on a local computer:
  * Step 1: [Clone] the repository from a git server (hereby github):
    - git clone #todo
  * Step 2: [Build] the project (download dependencies and build the project using Maven)
    - mvn clean install
  * Step 3: [Run] the project
    - mvn spring-boot:run
  * Step 4: [Test][Manual] Go to http://localhost:8080/swagger-ui.html to try the APIs out 
    
### Curls