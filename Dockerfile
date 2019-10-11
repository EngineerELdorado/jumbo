FROM java:8-jdk-alpine

COPY ./target/Jumbo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch Jumbo-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","Jumbo-0.0.1-SNAPSHOT.jar"]