package com.hcj.kafaka.Client;

import com.hcj.kafaka.Utils.KafkaUtil;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.Future;

/**
 * @author Administrator
 */
public class ProducerClient {

    private static Producer<String, String> producer = KafkaUtil.getProducer();

    public static void main(String[] args) {
        for(int i=0;i<5000;i++){
            try {
                final ProducerRecord<String, String> record = new ProducerRecord<String, String>("testTopic",
                        "d+key-" + i, "{\"name\":\"张三\",\"id\":\"1\"}");
                Future<RecordMetadata> send = producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if (e != null) {
                            e.printStackTrace();
                        }
                    }
                });

                System.out.println("sendToKafka-发送至Kafka:" + "d+key-" + i);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        producer.close();
    }
}
