FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

RUN useradd --system --create-home --uid 10001 appuser
COPY --from=build /workspace/target/library-deployment-backend-1.0.0.jar app.jar

USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
