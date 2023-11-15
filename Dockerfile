FROM amazoncorretto:17-alpine-jdk

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]