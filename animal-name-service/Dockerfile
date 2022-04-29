FROM openjdk:8-jdk-alpine
ADD target/animal-name-service-*.jar animal-name-service.jar
EXPOSE 9015
ENTRYPOINT [ "java", "-jar", "-Xms256m", "-Xmx2048m", "/animal-name-service.jar"]

# Xms256m -> JVM 256mb memory ile başlayacak.
# Xmx2048m -> max 2048mb memory tüketebilecek.