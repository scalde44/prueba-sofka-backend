FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY infrastructure/target/*.jar accounts-app.jar
ENTRYPOINT ["java","-jar","/accounts-app.jar"]