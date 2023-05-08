
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

#FROM openjdk:19-jdk-alpine
#WORKDIR /app
#COPY target/spring-s3-demo-0.0.1-SNAPSHOT.jar app.jar
##EXPOSE 8282
#ENTRYPOINT ["java","-jar","app.jar"]
FROM openjdk:19-jdk-alpine

RUN apk add --no-cache fontconfig ttf-dejavu

WORKDIR /workspace/app

COPY target/spring-s3-demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
