package com.alexb.kafka;

import com.alexb.kafka.consumer.Consumer;
import com.alexb.kafka.model.Message;
import com.alexb.kafka.model.Record;
import com.alexb.kafka.model.Status;
import com.alexb.kafka.producer.Producer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTest {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, 6, "test-p4");

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("kafka.bootstrap-servers", embeddedKafka.getBrokersAsString());
    }

    @Before
    public void setUp() throws Exception {
        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer, embeddedKafka.getPartitionsPerTopic());
        }
    }

    @Test
    public void should_produce_and_consume() throws Exception {
        List<String> list = Arrays.asList("ab", "key5", "hgtp", "key5", "hello", "e2", "key5", "oooo9h", "key5", "key5", "456", null);
        Collections.shuffle(list);

        list.forEach(e -> {
                Record record = new Record();
                record.setMessage(new Message("id", "message"));
                record.setStatus(Status.ACTIVE);
                record.setTags(Collections.emptyList());
                producer.send(e, record);
        });


        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(consumer.getLatch().getCount()).isEqualTo(0);
    }
}
