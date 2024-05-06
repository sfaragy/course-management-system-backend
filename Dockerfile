
FROM maven:3.8.5-openjdk-17 AS build-rest-img
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean package -DskipTests

FROM build-rest-img AS test
RUN mvn test

FROM maven:3.8.5-openjdk-17
WORKDIR /app
COPY target/minden-rest-api-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
#CMD mvn spring-boot:run