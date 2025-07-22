FROM amazoncorretto:21.0.7-alpine3.18

WORKDIR /app

COPY ../target/auth-service.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
