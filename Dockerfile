# Use a base image with OpenJDK 11 installed
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY /target/classes/JavaAgent-1.0-SNAPSHOT.jar /app/JavaAgent-1.0-SNAPSHOT.jar

# Copy the Java agent JAR file into the container
COPY /target/HyperTest-Application-0.0.1-SNAPSHOT.jar /app/HyperTest-Application-0.0.1-SNAPSHOT.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Set environment variables
ENV API_ENDPOINT=ch
ENV DB_HOST=localhost
ENV DB_NAME=HyperTest
ENV DB_PASSWORD=5448
ENV DB_PORT=3306
ENV DB_USERNAME=root

# Specify the command to run the Spring Boot application when the container starts
CMD ["java", "-javaagent:/app/JavaAgent-1.0-SNAPSHOT.jar", "-jar", "/app/HyperTest-Application-0.0.1-SNAPSHOT.jar"]
