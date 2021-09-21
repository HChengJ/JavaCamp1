package com.hcj.kafaka.Utils;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * @author Administrator
 */
public class KafkaUtil {
    //kafka集群地址
    public static final String servers="PLAINTEXT:/127.0.0.1:9091,PLAINTEXT://127.0.0.1:9092,PLAINTEXT://127.0.0.1:9093";
    //kafka集群生产者配置
    public static KafkaProducer<String, String> getProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers",servers );
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 0);//16384
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kp = new KafkaProducer<String, String>(props);
        return kp;
    }

    //kafka集群消费者配置
    public static KafkaConsumer<String, String> getConsumer(String groupId) {

        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("auto.offset.reset", "earliest");
        props.put("group.id", groupId);
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "100");
        props.put("max.partition.fetch.bytes", "10240");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> kc = new KafkaConsumer<String, String>(props);
        return kc;
    }
}
