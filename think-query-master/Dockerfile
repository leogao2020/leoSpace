# 第一阶段：构建和打包应用
FROM arm64v8/maven:3.8.1  AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# 第二阶段：运行应用
FROM arm64v8/openjdk
#FROM openjdk:8-jre-alpine
WORKDIR /app

COPY --from=builder /app/start/target/lib /app/lib
#COPY --from=builder /app/think-query-master-app/target/lib/*.jar /app/lib
#COPY --from=builder /app/think-query-master-app/lib/*.jar /app/lib
COPY --from=builder /app/start/target/start-1.0.0-SNAPSHOT.jar /app/start.jar
EXPOSE 8081
#CMD ["java", "-jar", "start.jar"]

ENV JAVA_OPTS=$JAVA_OPTS
ENTRYPOINT [ "sh", "-c", "java -cp '/app/lib/:/app/start.jar' -jar /app/start.jar" ]
