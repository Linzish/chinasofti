FROM openjdk:8u232-jdk-slim
VOLUME /tmp
ADD *.jar app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]
