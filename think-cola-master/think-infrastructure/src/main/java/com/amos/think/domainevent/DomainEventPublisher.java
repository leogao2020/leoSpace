package com.amos.think.domainevent;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * DomainEventPublisher类用于发布领域事件到Kafka主题。
 * 通过KafkaTemplate简化了消息发送的流程。
 */
@Component
public class DomainEventPublisher {

    // 自动装配KafkaTemplate，用于发送消息至Kafka
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发布消息到指定的Kafka主题。
     *
     * @param topic 将消息发送到的Kafka主题名称。
     * @param msg 要发送的消息对象。
     * 注：不返回任何内容，方法执行结果仅依赖于消息是否成功发送至Kafka。
     */
    public void publish(String topic, Object msg){
        try {
            // 创建一个新的ProducerRecord，指定主题和消息内容
            ProducerRecord<String, Object> pr = new ProducerRecord<>(topic, msg);

            // 为消息添加一个头部信息，记录消息的类型，便于消费者处理
            pr.headers().add("type", msg.getClass().getName().getBytes(StandardCharsets.UTF_8));
            kafkaTemplate.send(pr);
        } catch (Exception ex) {
            // 捕获并打印发送消息过程中可能发生的异常
            ex.printStackTrace();
        }
    }
}

