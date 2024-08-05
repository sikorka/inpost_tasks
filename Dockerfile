# syntax=docker/dockerfile:1

# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/go/dockerfile-reference/

# Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7

################################################################################

# Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:21

WORKDIR /

# Copy the mvnw wrapper with executable permissions.
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/

COPY / /

RUN ./mvnw install -DskipTests

