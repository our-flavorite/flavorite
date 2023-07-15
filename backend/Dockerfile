FROM amazoncorretto:17
ARG JAR_FILE=bootstrap/build/libs/*.jar
COPY ${JAR_FILE} bootstrap.jar
ENTRYPOINT ["java", "-jar", "/bootstrap.jar"]
