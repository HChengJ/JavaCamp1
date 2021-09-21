package io.kimmking.kmq.core;

/**
 * @author Administrator
 */
public class MyProducer {
    private MyBroker broker;

    public MyProducer(MyBroker broker) {
        this.broker = broker;
    }

    public boolean send(String topic, MyMessage message) {
        Mymq kmq = this.broker.findMq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return kmq.send(message);
    }
}
