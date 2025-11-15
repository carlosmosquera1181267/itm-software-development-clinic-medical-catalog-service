FROM gradle:8.7-jdk17 AS builder
LABEL authors="carlosm"

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

RUN ./gradlew clean build -x test


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]