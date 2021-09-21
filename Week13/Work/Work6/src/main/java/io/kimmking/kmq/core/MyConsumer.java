package io.kimmking.kmq.core;

/**
 * @author Administrator
 */
public class MyConsumer<T> {
    private final MyBroker broker;

    private Mymq myMq;

    public MyConsumer(MyBroker myBroker) {
        this.broker = myBroker;
    }

    public void subscribe(String topic) {
        this.myMq = this.broker.findMq(topic);
        if (null == myMq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public MyMessage<T> poll() {
        return myMq.poll();
    }
}
