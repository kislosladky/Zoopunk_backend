FROM gradle:7.4.1-jdk17 AS compile-image

WORKDIR /app
ARG GRADLE_ARG="build --no-daemon"
COPY . /app
COPY *.gradle.kts /app

USER root
RUN chown -R gradle /app
USER gradle
RUN gradle ${GRADLE_ARG}

FROM openjdk:17-jdk AS runtime-image

COPY --from=compile-image /app/build/libs/*.jar app.jar

CMD [ "/bin/bash", "-c", "java -jar app.jar"]
