#FROM maven:3.8.1-jdk-11 AS build_stage
#WORKDIR /app
#COPY . .
#RUN mvn clean install -DskipTests

FROM openjdk:11-jdk
WORKDIR /
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.phuc.icommerce.IcommerceApplication", "--spring.datasource.url=jdbc:postgresql://db:5432/icommerce", "--spring.datasource.username=icommerce", "--spring.datasource.password=icommerce"]