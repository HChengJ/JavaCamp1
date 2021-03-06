package io.kimmking.kmq.demo;

import io.kimmking.kmq.core.*;

import lombok.SneakyThrows;

public class KmqDemo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "kk.test";
//        KmqBroker broker = new KmqBroker();
//        broker.createTopic(topic);
        MyBroker myBroker = new MyBroker();
        myBroker.createTopic(topic);

//        KmqConsumer consumer = broker.createConsumer();
//        consumer.subscribe(topic);
        MyConsumer myConsumer = myBroker.createConsumer();
        myConsumer.subscribe(topic);
        final boolean[] flag = new boolean[1];
        flag[0] = true;
        new Thread(() -> {
            while (flag[0]) {
//                KmqMessage<Order> message = consumer.poll(100);
//                if(null != message) {
//                    System.out.println(message.getBody());
//                }
                MyMessage<Order> msg = myConsumer.poll();
                if(null != msg) {
                    System.out.println(msg.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();

//        KmqProducer producer = broker.createProducer();
//        for (int i = 0; i < 1000; i++) {
//            Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
//            producer.send(topic, new KmqMessage(null, order));
//        }
        MyProducer myProducer = myBroker.createProducer();
        for (int i = 0; i < 1000; i++) {
            Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
            myProducer.send(topic, new MyMessage(order));
        }
        Thread.sleep(500);
        System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");
//        while (true) {
//            char c = (char) System.in.read();
//            if(c > 20) {
//                System.out.println(c);
//                producer.send(topic, new KmqMessage(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
//            }
//
//            if( c == 'q' || c == 'e') break;
//        }
        while (true) {
            char c = (char) System.in.read();
            if(c > 20) {
                System.out.println(c);
                myProducer.send(topic, new MyMessage( new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
            }

            if( c == 'q' || c == 'e') break;
        }

        flag[0] = false;

    }
}
