# Primero se construye el proyecto
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Generamos las dependencias del proyecto
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el codigo fuente
COPY src ./src

# Se compila el proyecto
RUN mvn clean package -DskipTests

# Creamos la imagen de jdk para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el jar generado previamente
COPY --from=build /app/target/Pokemon-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
