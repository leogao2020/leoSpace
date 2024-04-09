package com.amos.think.domainevent;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class DomainEventPublisher {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void publish(String topic, Object msg){
        try {
            // publish event
            ProducerRecord<String, Object> pr = new ProducerRecord<>(topic, msg);
            pr.headers().add("type", msg.getClass().getName().getBytes(StandardCharsets.UTF_8));
            kafkaTemplate.send(pr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
