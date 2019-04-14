package com.alexb.kafka.serializer;

import com.alexb.kafka.model.Message;
import com.alexb.kafka.model.Record;
import com.alexb.kafka.model.Status;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class AvroSerializerTest {

    @Test
    public void should_serialize() {
        Record record = new Record();
        record.setMessage(new Message("id", "message"));
        record.setStatus(Status.ACTIVE);
        record.setTags(Collections.emptyList());

        AvroSerializer<Record> avroSerializer = new AvroSerializer<>();
        assertThat(avroSerializer.serialize("test", record))
                .isEqualTo(DatatypeConverter.parseHexBinary("000469640E6D6573736167650000"));

        avroSerializer.close();
    }
}
