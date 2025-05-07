# Use JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project
COPY . /app

# Build project
RUN ./mvnw clean package -DskipTests

# Run jar
CMD ["java", "-jar", "target/StudentSurvey-0.0.1-SNAPSHOT.war"]
