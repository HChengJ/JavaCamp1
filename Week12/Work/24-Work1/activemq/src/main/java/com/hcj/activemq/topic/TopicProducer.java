package com.hcj.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Administrator
 */
public class TopicProducer {

    private static final String url = "tcp://localhost:61616";
    private static final String topicName = "topic1";
    public static void main(String[] args) throws JMSException {
        System.out.println("TopicSender启动了...");
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁
        //Destination destinaction;
        //topic 话题
        Topic topic;
        // MessageProducer：消息发送者
        MessageProducer producer;
        // TextMessage message;
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, url);
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值mytopic是一个服务器的topic，须在在ActiveMq的console配置
            topic = session.createTopic(topicName);
            // 得到消息生成者【发送者】
            producer = session.createProducer(topic);
            // 设置不持久化
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 消息体
            for (int i = 1; i <= 100; i++) {
                TextMessage message = session.createTextMessage("topic message" + i);
                System.out.println("Sender发送消息：" + "topic message" + i);
                producer.send(message);
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }

    }
}
