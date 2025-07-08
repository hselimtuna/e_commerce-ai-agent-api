FROM amazoncorretto:21.0.7-alpine3.18

MAINTAINER Halil Selim Tuna <hselimtuna@gmail.com>

WORKDIR /app

COPY ../target/platform-service.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]