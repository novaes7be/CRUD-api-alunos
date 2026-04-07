# Etapa de build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copiando arquivos do Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copiando código-fonte
COPY src ./src
RUN ./mvnw package -DskipTests

# Etapa final: imagem de execução
FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/target/api-alunos-0.0.1-SNAPSHOT.jar ./api-alunos.jar

EXPOSE 8080
CMD ["java", "-jar", "api-alunos.jar"]