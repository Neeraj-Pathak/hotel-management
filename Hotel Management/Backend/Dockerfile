# Stage 1: Build backend
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# Stage 3: Final image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the exact jar file
COPY --from=build /app/target/Hotel-Management-0.0.1-SNAPSHOT.jar .


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Hotel-Management-0.0.1-SNAPSHOT.jar"]
