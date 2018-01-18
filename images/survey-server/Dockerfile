FROM openjdk:8u151-jdk-alpine
RUN apk add --no-cache bash
COPY swagger-spring-1.0.0.jar /usr/src/survey-server/
COPY wait-for-it.sh /usr/local/
CMD ["java", "-jar", "/usr/src/survey-server/swagger-spring-1.0.0.jar"]
