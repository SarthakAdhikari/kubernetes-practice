# Use OpenJDK for running the application
FROM amazoncorretto:17-alpine

# Set the working directory in the Docker image
WORKDIR /usr/app

# Copy the pre-built jar file from your local machine to the Docker image
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

# Expose the port your app uses (default to 8080 unless your app uses a different port)
EXPOSE 8000

# Command to run your app
CMD ["java", "-jar", "user-service.jar", "--spring.profiles.active=prod"]

