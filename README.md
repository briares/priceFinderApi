http://localhost:8080/priceApi/api-docs/

http://localhost:8080/priceApi/swagger-ui/index.html?configUrl=/priceApi/api-docs/swagger-config#/

Database load

http://localhost:8080/priceApi/h2-console
JDBC URL: jdbc:h2:mem:priceReporting
User: sa
Password: testdb


Use logback file in production

lombok
dto decission

Execition of test
gradlew clean guild
gradle2 test

curl
postman collection

Execute test with gradle
./gradlew clean build

Run the app
./gradlew bootrun

Run as docker image
1) build the image (I use gradle)
   Move to the root folder of the project and run:
   ./gradlew bootBuildImage --imageName=briares/priceapi
   
2) Run container
   docker run -p 8080:8080 -t briares/priceapi


logback file
save in github

Questions
Request param Date or Datetime?