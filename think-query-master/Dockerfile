# 第一阶段：构建和打包应用
FROM arm64v8/maven:3.8.1 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行应用
FROM arm64v8/openjdk
WORKDIR /app


COPY --from=builder /app/start/target/start-1.0.0-SNAPSHOT-jar-with-dependencies.jar /app/start-1.0.0-SNAPSHOT-jar-with-dependencies.jar
EXPOSE 8081
CMD ["java", "-jar", "start-1.0.0-SNAPSHOT-jar-with-dependencies.jar"]
