FROM openjdk:21-jdk-slim AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests

FROM openjdk:21-jre-slim

WORKDIR /app

COPY --from=build /app/target/api-academica.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "api-academica.jar"]