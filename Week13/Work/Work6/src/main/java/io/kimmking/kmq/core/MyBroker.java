package io.kimmking.kmq.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
public class MyBroker {
    public static final int CAPACITY = 10000;

    private final Map<String, Mymq> mqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        mqMap.putIfAbsent(name, new Mymq(name,CAPACITY));
    }

    public Mymq findMq(String topic) {
        return this.mqMap.get(topic);
    }

    public MyProducer createProducer() {
        return new MyProducer(this);
    }

    public MyConsumer createConsumer() {
        return new MyConsumer(this);
    }
}
