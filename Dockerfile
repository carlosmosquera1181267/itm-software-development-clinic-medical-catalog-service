FROM gradle:8.7-jdk21-alpine AS builder
LABEL authors="carlosm"

WORKDIR /app

COPY medical-catalog-service/build.gradle medical-catalog-service/settings.gradle medical-catalog-service/gradlew ./
COPY medical-catalog-service/gradle ./gradle
COPY medical-catalog-service/src ./src

RUN ./gradlew clean build -x test


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]