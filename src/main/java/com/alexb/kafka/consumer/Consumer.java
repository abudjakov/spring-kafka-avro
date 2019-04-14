package com.alexb.kafka.consumer;

import com.alexb.kafka.model.Record;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class Consumer {

    public static CountDownLatch latch = new CountDownLatch(12);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(groupId = "${kafka.groupId}", topics = "${kafka.topic}")
    public void receive(ConsumerRecord<String, Record> record) {
        log.info("Received key: {}, record: {}", record.key(), record.value());

        latch.countDown();
    }
}
