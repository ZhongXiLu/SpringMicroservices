FROM openjdk:11-jdk-slim

ADD target/hello-web-*.jar hello-web.jar

ENTRYPOINT ["java", "-jar", "/hello-web.jar"]

EXPOSE 8080