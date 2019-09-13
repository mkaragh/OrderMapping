FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/OrderMapping-0.0.1-SNAPSHOT.jar OrderMapping.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/OrderMapping.jar"]