package com.hcj.kafaka.Client;

import com.hcj.kafaka.Utils.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class ConsumerClient {
    public  static KafkaConsumer<String, String> consumer = null;

    public static void main(String[] args) {
        consumer = KafkaUtil.getConsumer("testGroup");
        consumer.subscribe(Arrays.asList("testTopic"));

        int i=0;
        while (true) {
            ConsumerRecords<String, String> records ;
            try {
                records = consumer.poll(Long.MAX_VALUE);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

            for (ConsumerRecord<String, String> record : records) {
                System.out.println("fetched from partition " + record.partition() + ", offset: " + record.offset() + ",key: " + record.key() + ",value:" + record.value() );
                i++;
                System.out.println(i);
            }

            try {
                consumer.commitSync();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }



        }
    }
}
