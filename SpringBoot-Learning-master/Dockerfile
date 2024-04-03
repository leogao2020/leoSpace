# Stage 1: Build the application
FROM gradle:latest as builder
WORKDIR /app
COPY . .
RUN gradle build

# Stage 2: Create the final image
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=builder /app/SpringBoot-RateLimiter/build/libs/*.jar SpringBoot-RateLimiter-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "SpringBoot-RateLimiter-1.0.0.jar"]