FROM openjdk:11-jdk-slim

ADD target/hello-*.jar hello.jar

ENTRYPOINT ["java", "-jar", "/hello.jar"]

EXPOSE 8080