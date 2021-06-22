#FROM maven:3.8.1-jdk-11 AS build_stage
#WORKDIR /app
#COPY . .
#RUN mvn clean install -DskipTests

FROM openjdk:11-jre-alpine
WORKDIR /app
COPY target .
CMD