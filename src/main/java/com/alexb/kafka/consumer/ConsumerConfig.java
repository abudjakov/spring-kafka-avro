package com.alexb.kafka.consumer;

import com.alexb.kafka.model.Record;
import com.alexb.kafka.serializer.AvroDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
@EnableKafka
@Slf4j
public class ConsumerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> config() {
        Map<String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ENABLE_AUTO_COMMIT_CONFIG, true);
        config.put(AUTO_OFFSET_RESET_CONFIG, "latest");

        log.info("Kafka Consumer config is created with bootstrap.servers: {}", bootstrapServers);
        return config;
    }

    @Bean
    public ConsumerFactory<String, Record> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(config(), new StringDeserializer(), new AvroDeserializer<>(Record.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Record> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Record> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(5);

        return factory;
    }

    @Bean
    public Consumer consumer() {
        return new Consumer();
    }
}
