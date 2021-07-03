## Price Api

Project example that uses spring Rest & spring repository

## How to build with Gradle

This project is a gradle project (gradle wrapper version 7 included)

> ./gradlew clean build

To run the project as Spring boot application, you can use:

> ./gradlew bootrun

## How to build with Docker

The application includes a docker file and you can use gradle to build the image.

> ./gradlew bootBuildImage --imageName=briares/priceapi

Then you can run the container:

> docker run -p 8080:8080 -t briares/priceapi
  
---
**NOTE**

This app use port 8080, so be sure that any other application is using that port

---

## Swagger

I've included Open Api documentation in this app. Once the application is running you can use swagger-ui using your browser: 

http://localhost:8080/priceApi/swagger-ui/index.html?configUrl=/priceApi/api-docs/swagger-config#/

## Curl is another client Api you can use. Here is an example: 
```
curl -X 'GET' \
'http://localhost:8080/priceApi/prices?brandId=1&productId=35455&dateOfApplication=2020-06-14T10%3A37%3A50.483Z' \
-H 'accept: application/json'
```
## Database

The app uses an in-memory h2 database. That means that every time the application is restarted, the database is dropped and created once again.

There are two files in the classpath under the resource directory (data.sql & schema.sql), that creates the schema
database and populates the database with data.

If you want to access the database console you can do it using your browser with this URL: http://localhost:8080/priceApi/h2-console,
and then you have to specify this parameters:

```
JDBC URL: jdbc:h2:mem:priceReporting
User: sa
Password: testdb
```

## Technical considerations
* The application uses Lombok because simplifies development
* The application uses mapstruts to map from Dto to Models and viceversa
* I don't use a logback file, it is configured in application.yml, but for 
  production, should be a best practice to use logback file.
* I use dto's to transport data between layers. I know, that are some detractors 
  that tell that is better not to use dto's, but I think that in general is not
  a bad practice. Another approach could be using hexagonal architectures with ports and
  adaptaters (that I'm using in some of my current projects), but this is a simple
  project and I considered that adding this extra layer is over engineering.
* For the data access layer, I use Spring Data with and a custom jpql query to solve the problem 
  of search the price of the product.   


postman collection


Questions
Request param Date or Datetime?
