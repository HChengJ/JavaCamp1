package com.hcj.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Administrator
 */
public class TopicConsumer {

    private static final String url="tcp://localhost:61616";
    private  static final String topicName="topic1";
    public static void main(String[] args) throws JMSException {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, url);
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            //当生产者采用持久化策略时，ClientID用以别区哪个客户端已经接收过
            //connection.setClientID("hh");
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值mytopic是一个服务器的topic，须在在ActiveMq的console配置
            destination = session.createTopic(topicName);
            consumer = session.createConsumer(destination);
            System.out.println("我是订阅者1");
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(message instanceof TextMessage){
                        try {
                            TextMessage text=(TextMessage)message;
                            System.out.println("收到消息" + text.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
