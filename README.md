# spring-boot-microservices

The purpose of **spring-boot-microservices** project is to learn how to build a microservice using Spring Boot Framework. **spring-boot-microservices** project contains sub projects one is **api** & other is **endpoint-tests**. **api** project contains the implementation of Account REST API using Spring Boot as part of implementation CRUD operation is implemented and H2 database is integrated using JPA also unit tests are implemented using **junit, mockito & jacoco**. **endpoint-tests** project contains the integration test implemented using **Rest-Assured**.

## Getting Started
Clone [spring-boot-microservices](git@github.com:sagar-jadhav/spring-boot-microservices.git) and open **api** & **endpoint-tests** with [Spring Tool Suite](https://spring.io/tools3/sts) you can use any other IDE as well.

## Prerequisites

To run Spring Boot based Account REST API it is prerequisite to have Java 8 installed on your machine.
[Steps to Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Contributing

Pull requests are welcome. I will appreciate any help on either enhancing existing example/program or addition of new example/program.

## Authors

* **Sagar Jadhav** - [sagar-jadhav](https://github.com/sagar-jadhav)

## Content

* [Account Controller](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/controller/AccountController.java)
* [Account Service](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/service/AccountService.java)
* [Account Repository](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/repository/AccountRepository.java)
* [Account Model](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/main/java/com/developers/thought/model/Account.java)
* [Account Controller Unit Test](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/api/src/test/java/com/developers/thought/controller/AccountControllerTest.java)
* [Account Service Unit Test](https://github.com/sagar-jadhav/spring-boot-microservices/tree/master/api/src/test/java/com/developers/thought/service)
* [Account Endpoint Test](https://github.com/sagar-jadhav/spring-boot-microservices/blob/master/endpoint-tests/src/test/java/com/developers/thought/endpoint/tests/EndpointTest.java)

