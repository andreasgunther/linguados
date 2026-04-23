# Estágio 1: Compilação (Build)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o arquivo de configuração do Maven
COPY pom.xml .
COPY src ./src

# Baixa as dependências (agiliza builds futuros se o pom não mudar)
RUN mvn dependency:go-offline

# Copia o código fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Runtime)
FROM tomcat:10.1-jdk21-temurin
# Remove as apps padrão do Tomcat para ficar limpo
RUN rm -rf /usr/local/tomcat/webapps/*
# Copia o seu WAR gerado para dentro do Tomcat
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]