# 第一阶段：构建和打包应用
FROM arm64v8/maven:3.8.1  AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行应用
# mla132/jre-17-slim
FROM arm64v8/openjdk
WORKDIR /app
COPY --from=builder /app/think-start/target/think-start-jar-with-dependencies.jar /app/think-start-jar-with-dependencies.jar
EXPOSE 8080
CMD ["java", "-jar", "think-start-jar-with-dependencies.jar"]
