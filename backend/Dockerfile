FROM gradle:jdk17 AS compile-image

WORKDIR /app
COPY . /app

RUN gradle build -x test

FROM arm32v7/eclipse-temurin:17-jre AS runtime-image

COPY --from=compile-image /app/build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
