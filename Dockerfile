FROM amazoncorretto:17-alpine-jdk
VOLUME /tmp
MAINTAINER mlu
COPY ./target/mu-0.0.1-SNAPSHOT.jar portfolioapp.jar
ENTRYPOINT ["java","-jar","portfolioapp.jar"]
