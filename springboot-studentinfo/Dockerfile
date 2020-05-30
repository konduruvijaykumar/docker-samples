FROM openjdk:8-jre

EXPOSE 8080

ADD ./target/springboot-studentinfo-0.0.1-SNAPSHOT.jar studentinfo.jar

ENTRYPOINT ["java", "-jar", "studentinfo.jar"]
