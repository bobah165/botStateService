FROM openjdk:17.0.1-jdk-slim
COPY build/libs/botStateService-1.0-SNAPSHOT.jar /app/botStateService.jar
EXPOSE 8003
CMD ["java", "-jar", "/app/botStateService.jar"]