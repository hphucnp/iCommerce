# I-COMMERCE Quick Start
ERD: ![icommerce ERD diagram](icommerceERD.png "icommerce ERD diagram")
### Explanation
 To whom it may concern, the development here is about microservice architecture where it is small service with minimum 
 dependencies and simple configuration. I follow SOLID principles to some extent, especially Interface Segregation. 
 I apply code first strategy when dealing with database.
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
  * Step 0: [Clone] the repository from a git server (hereby github):
    - git clone #todo
  * Step 1: Setup datasource , here I use postgres.
    If you want something run as is: 
      - Please have a postgres server with 
                  
            - a role : todo/todo
            - database: iCommerce
            - schema: icommerce 
      - Restore datadump from _icommerce.sql_
  * Step 2: [Build] the project (download dependencies and build the project using Maven)
    - mvn clean install
  * Step 3: [Run] the project
    - mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=\<your preferred port\>
  * Step 4: [Test][Manual] Go to http://localhost:8080/swagger-ui.html to try the APIs out 
    
### Curls
  * Get all products with brand `Pepsi`: 
    - curl --location --request GET 'http://localhost:7000/product?brand=Pepsi'
  * Get all products with brand `Pepsi` and category `food`:
    - curl --location --request GET 'http://localhost:7000/product?brand=Pepsi&category=food'
  * Get all products with price greater than or equal to `3000000`:
    - curl --location --request GET 'http://localhost:7000/product?startPrice=3000000'
  * Get all products with color `red` (case-insensitive):
    - curl --location --request GET 'http://localhost:7000/product?color=red'
  * Test add product to cart: curl --location --request POST 'http://localhost:7000/cart/1/1'