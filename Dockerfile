# Estágio 1: Compilação (Build)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o arquivo de configuração do Maven
COPY pom.xml .

# Baixa as dependências (agiliza builds futuros se o pom não mudar)
RUN mvn dependency:go-offline

# Copia o código fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Runtime)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia apenas o .jar gerado no estágio anterior
COPY --from=build /app/target/linguados-jar-with-dependencies.jar app.jar

# Define o comando de entrada para rodar a aplicação
# -it no docker-compose garantirá que o terminal fique aberto
ENTRYPOINT ["java", "-jar", "app.jar"]