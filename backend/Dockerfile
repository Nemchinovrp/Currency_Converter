FROM openjdk:8-jdk-alpine

LABEL maintainer="nemchinovrp@yandex.ru"

EXPOSE 8080

ARG JAR_FILE=target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} spring-boot-security-jwt.jar

ENTRYPOINT ["java","-jar","/spring-boot-security-jwt.jar"]