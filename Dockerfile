FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

# Copia o pom.xml e o código-fonte do projeto
COPY pom.xml .
COPY src ./src

# Executa o comando para fazer o build do projeto (gera o JAR)
RUN mvn clean package -DskipTests

# Usa uma imagem mais leve do JDK para rodar o app em produção
FROM eclipse-temurin:21-alpine

# Define o diretório de trabalho na nova imagem
WORKDIR /app

# Copia o JAR gerado da etapa anterior para a nova imagem
COPY --from=build /app/target/Trash-Management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prd

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "/app.jar"]
