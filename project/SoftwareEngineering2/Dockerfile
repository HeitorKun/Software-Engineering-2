# Use the official Gradle image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:7.4.2-jdk17-alpine as builder

# Copy local code to the container image.
WORKDIR /app
COPY gradlew .
COPY gradle gradle

COPY build.gradle .
COPY settings.gradle .
COPY src src

# Build a release artifact.
RUN ./gradlew build --no-daemon

# Use OpenJDK for smaller image size.
FROM openjdk:17-alpine

# Copy the jar to the production image from the builder stage.
COPY --from=builder /app/build/libs/*.jar /app.jar

# Run the web service on container startup.
CMD ["java", "-jar", "/app.jar"]
