FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/pet_back-end-0.0.1-SNAPSHOT.jar /app/petBackEnd.jar

EXPOSE 8080

CMD ["java", "-jar", "petBackEnd.jar"]