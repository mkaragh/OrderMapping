FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/VaidateOrder-0.0.1-SNAPSHOT.jar ValidateOrder.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ReceiveXCBLOrder.jar"]