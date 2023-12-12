FROM openjdk:17
ADD target/backend_px.jar backend_px.jar
ENTRYPOINT ["java", "-jar","backend_px.jar"]

EXPOSE 8080