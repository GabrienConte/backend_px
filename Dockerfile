FROM openjdk:17

ADD target/BackendPx.jar BackendPx.jar

ENTRYPOINT ["java", "-jar", "BackendPx.jar"]

EXPOSE 8080