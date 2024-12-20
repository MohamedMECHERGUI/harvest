#
# Build
#
FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package
#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build target/tempmatch-0.0.1-SNAPSHOT.jar ../lib/tempmatch.jar
ENTRYPOINT ["java","-jar","../lib/tempmatch.jar"]

