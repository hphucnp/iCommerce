# I-COMMERCE Quick Start
ERD: ![icommerce ERD diagram](https://github.com/hphucnp/iCommerce/blob/main/iCommerceERD.png?raw=true "icommerce ERD diagram")
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
    - `git clone https://github.com/hphucnp/iCommerce.git`
  * Step 1: Setup datasource , here I use postgres.
    If you want something run as is: 
      - Please have a postgres server with 
                  
            - a role : todo/todo
            - database: iCommerce
            - schema: icommerce 
      - Restore datadump from _icommerce.sql_
  * Step 2: [Build] the project (download dependencies and build the project using Maven)
    - `mvn clean install`
  * Step 3: [Run] the project
    - `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=\<your preferred port\>`
  


### Steps to run the application (with docker and docker-compose) on a local computer:
* Step 0: [Clone] the repository from a git server (hereby github):
    - `git clone https://github.com/hphucnp/iCommerce.git`
* Step 1: Build docker images:
    - docker-compose build
* Step 2: Run a cluster
    - `docker-compose up -d`
* Step 3: Create schema
    - `docker-compose exec db bash -c "su - postgres -c 'psql -U icommerce -c \"CREATE SCHEMA IF NOT EXISTS icommerce\"'"`
* Step 4: Force restart backend service to create schema structure (tables and constraints)
    - `docker-compose up -d --force-recreate icommerce`
* Step 5: Restore data dump      
    - `docker cp icommerce.sql db:/var/lib/postgresql/data/`
    - `docker-compose exec db bash -c "su - postgres -c 'psql -U icommerce < data/icommerce.sql'"`  
* Step 4: [Test][Manual] Go to http://localhost:8080/swagger-ui.html to try the APIs out

### Testing
  Unit tests are created using Junit5, SpringBootTest and H2 database. They are self-contained and will be run as is.
    
    - `mvn test`
  [Manual] Go to http://localhost:8080/swagger-ui.html to try the APIs out. Search API is not tested manually by Swagger (lack of parameters input). But you can try with postman or cURL ( below)
### Curls
  * Get all products with brand `Pepsi`: 
    - `curl --location --request GET 'http://localhost:7000/product?brand=Pepsi'`
  * Get all products with brand `Pepsi` and category `food`:
    - `curl --location --request GET 'http://localhost:7000/product?brand=Pepsi&category=food'`
  * Get all products with price greater than or equal to `3000000`:
    - `curl --location --request GET 'http://localhost:7000/product?startPrice=3000000'`
  * Get all products with color `red` (case-insensitive):
    - `curl --location --request GET 'http://localhost:7000/product?color=red'`
  * Test add product to cart: curl --location --request POST 'http://localhost:7000/cart/1/1'