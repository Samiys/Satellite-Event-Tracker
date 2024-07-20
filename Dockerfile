# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper scripts and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (caching layer)
RUN ./mvnw dependency:go-offline

# Copy the project source code
COPY src ./src

# Expose the port the app runs on
EXPOSE 7000

# Run the application using the Maven wrapper to enable hot-reloading
ENTRYPOINT ["./mvnw", "spring-boot:run"]
