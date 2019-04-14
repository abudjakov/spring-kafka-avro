package com.alexb.kafka.serializer;

import com.alexb.kafka.model.Message;
import com.alexb.kafka.model.Record;
import com.alexb.kafka.model.Status;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class AvroDeserializerTest {

    @Test
    public void should_deserialize() {
        Record record = new Record();
        record.setMessage(new Message("id", "message"));
        record.setStatus(Status.ACTIVE);
        record.setTags(Collections.emptyList());

        byte[] data = DatatypeConverter.parseHexBinary("000469640E6D6573736167650000");

        AvroDeserializer<Record> avroDeserializer = new AvroDeserializer<>(Record.class);

        assertThat(avroDeserializer.deserialize("test", data)).isEqualTo(record);
        avroDeserializer.close();
    }
}
