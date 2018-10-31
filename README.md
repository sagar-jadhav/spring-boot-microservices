# spring-boot-microservices

The purpose of **spring-boot-microservices** project is to learn how to build a microservice using Spring Boot Framework. **spring-boot-microservices** project contains **api** & **endpoint-tests** sub projects.The **api** project contains the implementation of Account REST API using Spring Boot.As part of implementation CRUD operation is implemented and H2 database is integrated using JPA also unit tests are implemented using **junit, mockito & jacoco** frameworks.The **endpoint-tests** project contains the integration test implemented using **Rest-Assured**.

## Project Highlights

* API
* Unit Tests
* Endpoint Tests
* Dockerfile

## Getting Started
Clone [spring-boot-microservices](https://github.com/sagar-jadhav/spring-boot-microservices.git) and open **api** & **endpoint-tests** with [Spring Tool Suite](https://spring.io/tools3/sts) you can use any other IDE as well.

## Prerequisites

To run Spring Boot based Account REST API it is prerequisite to have Java 8 & Docker installed on your machine.

* [Steps to Install Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Steps to Install Docker](https://docs.docker.com/install/)

## Contributing

Pull requests are welcome. I will appreciate any help on improving/enhancing the project.

## Authors

* **Sagar Jadhav** - [sagar-jadhav](https://github.com/sagar-jadhav)

## Content

* [Controller](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/controller/AccountController.java)
* [Service](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/service/AccountService.java)
* [Repository](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/repository/AccountRepository.java)
* [Model](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/model/Account.java)
* [Controller Unit Test](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/test/java/com/developers/thought/controller/AccountControllerTest.java)
* [Service Unit Test](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/test/java/com/developers/thought/service/AccountServiceTest.java)
* [Account Endpoint Test](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/endpoint-tests/src/test/java/com/developers/thought/endpoint/tests/EndpointTest.java)
* [Postman Collection](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/postman_collection.json)
* [API Dockerfile](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api_dockerfile)

## Youtube Tutorials

* [Spring Boot Micro Service Series](https://www.youtube.com/playlist?list=PL8NEsKyvtj7srK6_EBsuE7SFjYnnucnLl)

## Steps to Run Spring Boot based Account REST API

* Go to api directory. for e.g. cd <PATH_TO_CLONED_DIRECTORY>/api
* Run **./gradlew clean build**
* Run **java -jar ./build/libs/api-1.0.0.jar**

## Steps to Run Unit Test & Generate Jacoco Test Coverage Report

* Go to api directory. for e.g. cd <PATH_TO_CLONED_DIRECTORY>/api
* Run **./gradlew clean build test**
* Open file://<PATH_TO_CLONED_DIRECTORY>/api/build/reports/jacoco/test/html/index.html in any browser to view the coverage report 

## Steps to Run Endpoint Tests

* Go to endpoint-tests directory. for e.g. cd <PATH_TO_CLONED_DIRECTORY>/endpoint-tests
* Run **./gradlew clean build test**
* Open file://<PATH_TO_CLONED_DIRECTORY>/endpoint-tests/build/reports/tests/test/index.html in any browser to view the test report

## Steps to Build Docker Image

* Go to cloned directory. for e.g. cd <PATH_TO_CLONED_DIRECTORY>/
* Run **docker build -t <NAME_OF_IMAGE>:<TAG> -f api_dockerfile .** for e.g. docker build -t spring_boot_microservice:v1 -f api_dockerfile .
* Verify by running **docker images** command. After running this command you will newly created image listed here.

## Steps to Run Docker Image

* Run **docker run -p 8080:8080 <NAME_OF_IMAGE>:<TAG>** for e.g. docker run -p 8080:8080 spring_boot_microservice:v1

**Note**: [Subscribe](https://www.youtube.com/channel/UC72a--fChlkj5f-7jQhZuiw?sub_confirmation=1) to watch technological videos on different trending technologies
