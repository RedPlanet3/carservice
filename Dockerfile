FROM openjdk:17-ea-26-jdk-oraclelinux7
ARG JAR_FILE="target/car_service-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]