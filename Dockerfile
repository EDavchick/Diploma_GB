# Use OpenJDK image as the base image
FROM openjdk:21
WORKDIR qigongApp
#RUN apt-get update && apt-get install -y openjfx

# Copy the compiled JAR file into the Docker image
COPY target/qigongApp-1.0-SNAPSHOT.jar qigongApp/qigongapp.jar

# Set the entry point to run your application
ENTRYPOINT ["java", "-jar", "qigongapp.jar"]
