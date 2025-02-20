FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/*.jar eureka-app.jar
ENTRYPOINT ["java","-jar","/eureka-app.jar"]