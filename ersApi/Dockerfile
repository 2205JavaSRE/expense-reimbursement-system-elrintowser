#Building stage
FROM maven:3.8.5-eclipse-temurin-8-alpine AS MAVEN_BUILD
COPY ./ ./

RUN mvn clean package

#Distributable
FROM openjdk:8-jre

COPY --from=MAVEN_BUILD /target/ ./

CMD ["java","-jar","/mainDriver-0.0.1-SNAPSHOT.jar"]

