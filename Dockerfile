# Use OpenJDK 8 as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/SpringJDBC-0.0.1-SNAPSHOT.jar app.jar

# Copy resources (including abstractWallpaper.jpg)
COPY src/main/resources /app/resources

# Expose the port that Spring Boot runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
