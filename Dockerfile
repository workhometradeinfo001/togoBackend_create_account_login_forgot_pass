#Build jdk with maven
# ==========================================
# STAGE 1: Build Stage (JDK + Maven)
# ==========================================
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /dockerFolder

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests


#==========================================
# STAGE 2: Run Environment setup
#==========================================

FROM eclipse-temurin:21-jre
WORKDIR /dockerFolder

COPY --from=build /dockerFolder/target/*.jar lrf-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "lrf-service.jar"]

