FROM openjdk:8u232-jdk-slim
VOLUME /tmp
ADD *.jar app.jar
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
