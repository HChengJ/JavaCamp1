package com.hcj.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Administrator
 */
public class QueueProducer {
    private static final String url = "tcp://localhost:61616";
        private static final String queueName = "queue1";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);

        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("消息" + i);
            producer.send(textMessage);
            System.out.println("发送消息：" + textMessage.getText());
        }
        connection.close();
    }
}
