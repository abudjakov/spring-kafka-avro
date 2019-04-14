package com.alexb.kafka.producer;

import com.alexb.kafka.model.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class Producer {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Record> kafkaTemplate;

    public void send(String key, Record record) {
        log.info("Send record: {} to topic: {}", record, topic);
        kafkaTemplate.send(topic, key, record);
    }
}
