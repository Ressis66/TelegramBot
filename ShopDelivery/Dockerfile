FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shop-delivery.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/shop-delivery.jar"]