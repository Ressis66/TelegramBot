FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} telegram-shop.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/telegram-shop.jar"]