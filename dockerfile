FROM java:8

ADD /build/libs/meetup-0.0.1-SNAPSHOT.jar /meetup-0.0.1-SNAPSHOT.jar

WORKDIR /

EXPOSE 8080

ENTRYPOINT ["java","-jar","meetup-0.0.1-SNAPSHOT.jar"]
