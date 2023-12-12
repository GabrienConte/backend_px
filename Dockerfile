FROM openjdk:17

ADD target/classes backendpx

ENTRYPOINT ["java", "-cp" , "target/classes", "BackendPxApplication.class"]

EXPOSE 8080