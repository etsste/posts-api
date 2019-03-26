FROM openjdk:8-jdk-alpine
ADD ./target/*.jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]