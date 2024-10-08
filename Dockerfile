FROM openjdk:21-slim

# Set the working directory
WORKDIR /app

COPY target/devops-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 2020

ENTRYPOINT ["java", "-jar", "app.jar"]
