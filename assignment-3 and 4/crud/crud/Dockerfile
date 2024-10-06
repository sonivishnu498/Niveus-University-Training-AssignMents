
FROM openjdk:17-jdk-slim


WORKDIR /app


COPY pom.xml .
COPY src ./src



COPY target/crud-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]


EXPOSE 8080
