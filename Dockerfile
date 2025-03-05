FROM openjdk:18-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Makefile and source code
COPY *.java .
