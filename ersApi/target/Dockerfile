FROM openjdk:8-jdk

ADD mainDriver-0.0.1-SNAPSHOT.jar mainDriver-0.0.1-SNAPSHOT.jar
ADD /libs /libs
ENV db_url=jdbc:postgresql://ers-database.cxzigkpx8vgp.us-east-1.rds.amazonaws.com:5432/postgres
ENV db_username=elrin
ENV db_password=bilbo123


CMD ["java","-jar","mainDriver-0.0.1-SNAPSHOT.jar"]
