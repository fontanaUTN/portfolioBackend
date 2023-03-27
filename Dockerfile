FROM amazoncorretto:11-alpine-jdk
MAINTAINER fontana
COPY target/fontana-0.0.1-SNAPSHOT.jar fontana-app.jar
ENTRYPOINT ["java","-jar","/fontana-app.jar"]