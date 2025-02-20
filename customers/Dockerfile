FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY infraestructure/target/*.jar customers-app.jar
ENTRYPOINT ["java","-jar","/customers-app.jar"]