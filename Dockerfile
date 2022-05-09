FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/spe_backend-0.0.1-SNAPSHOT.jar springboot.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot.jar"]

