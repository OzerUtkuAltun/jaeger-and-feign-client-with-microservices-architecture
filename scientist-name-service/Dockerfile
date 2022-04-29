FROM openjdk:8-jdk-alpine
ADD target/scientist-name-service-*.jar scientist-name-service.jar
EXPOSE 9016
ENTRYPOINT [ "java", "-jar", "-Xms256m", "-Xmx2048m", "/scientist-name-service.jar"]