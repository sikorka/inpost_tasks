# syntax=docker/dockerfile:1

# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/go/dockerfile-reference/

# Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7

################################################################################

# Create a stage for resolving and downloading dependencies.
# FROM eclipse-temurin:1.8-jdk-jammy as deps
#
# WORKDIR /
#
# # Copy the mvnw wrapper with executable permissions.
# COPY --chmod=0755 mvnw mvnw
# COPY .mvn/ .mvn/
#
# # Download dependencies as a separate step to take advantage of Docker's caching.
# # Leverage a cache mount to /root/.m2 so that subsequent builds don't have to
# # re-download packages.
# RUN --mount=type=bind,source=pom.xml,target=pom.xml \
#     --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline -DskipTests

################################################################################

# Create a stage for building the application based on the stage with downloaded dependencies.
# This Dockerfile is optimized for Java applications that output an uber jar, which includes
# all the dependencies needed to run your app inside a JVM. If your app doesn't output an uber
# jar and instead relies on an application server like Apache Tomcat, you'll need to update this
# stage with the correct filename of your package and update the base image of the "final" stage
# use the relevant app server, e.g., using tomcat (https://hub.docker.com/_/tomcat/) as a base image.
FROM deps as package

WORKDIR /inpost-common


RUN --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=cache,target=/root/.m2 \
    ./mvnw install -DskipTests

################################################################################

FROM eclipse-temurin:1.8-jre-jammy AS final

RUN mvn clean test


