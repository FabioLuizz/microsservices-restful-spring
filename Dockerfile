FROM openjdk:17-jdk
VOLUME /TMP

ENV ENV SPRING_PROFILES_ACTIVE=prd

EXPOSE 8080

ARG JAR_FILE=target/Trash-Management-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar","/app.jar"]