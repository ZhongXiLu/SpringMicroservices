FROM openjdk:11-jdk-slim

ADD target/discovery-*.jar discovery.jar

ENTRYPOINT ["java", "-jar", "/discovery.jar"]

EXPOSE 8761