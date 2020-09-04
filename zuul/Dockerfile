FROM openjdk:11-jdk-slim

ADD target/zuul-*.jar zuul.jar

ENTRYPOINT ["java", "-jar", "/zuul.jar"]

EXPOSE 8762