# 第一阶段：构建和打包应用
FROM arm64v8/maven:3.8.1  AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行应用
# mla132/jre-17-slim
FROM arm64v8/openjdk
WORKDIR /app
COPY --from=builder /app/think-start/target/lib /app/lib
COPY --from=builder /app/think-start/target/think-start-1.0.0-SNAPSHOT.jar /app/think-start.jar
EXPOSE 8080
#CMD ["java", "-jar", "think-start.jar"]
ENV MYSQL_NAME_PORT="mysql-server:3306"
ENV KAFKA_NAME_PORT="kafka-server:9092"
ENV JAVA_OPTS=$JAVA_OPTS
ENTRYPOINT [ "sh", "-c", "java -cp '/app/lib/*:/app/think-start.jar:' -jar /app/think-start.jar" ]
