FROM eclipse-temurin:21-alpine
VOLUME /TMP

ENV PROFILE=prd

EXPOSE 8080

ARG JAR_FILE=target/Trash-Management-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar","/app.jar"]