FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/proteus-0.1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]