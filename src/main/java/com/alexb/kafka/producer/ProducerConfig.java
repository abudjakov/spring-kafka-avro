package com.alexb.kafka.producer;

import com.alexb.kafka.model.Record;
import com.alexb.kafka.serializer.AvroSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class ProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> config() {
        Map<String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);

        return config;
    }

    @Bean
    public ProducerFactory<String, Record> kafkaProducerFactory() {
        return new DefaultKafkaProducerFactory<>(config());
    }

    @Bean
    public KafkaTemplate<String, Record> kafkaTemplate() {
        return new KafkaTemplate<>(kafkaProducerFactory());
    }

    @Bean
    public ProducerListener<Object, Object> kafkaProducerListener() {
        return new LoggingProducerListener<>();
    }

    @Bean
    public Producer producer() {
        return new Producer();
    }
}
