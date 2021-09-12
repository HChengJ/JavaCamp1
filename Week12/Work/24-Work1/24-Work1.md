24-Work1

环境：操作系统：win6 x64

​			jdk1.8

​			activeMQ5.15.0

安装activeMQ过程忽略。

**使用queue，生产者发送100个消息到activeMQ，消费者接收100个消息。**

执行生产者后可以看到activeMQ的 Queues 中可以看到

```

Name  	Number Of Pending Messages  	Number Of Consumers  	Messages Enqueued  	 Messages Dequeued
queue1					100					0						100						0
```



消费者启动后，可以看到上面变化如下：

```

Name  	Number Of Pending Messages  	Number Of Consumers  	Messages Enqueued  	Messages Dequeued 
queue1					0					1						100						100
```

以上说明生产者通过MQ将消息传递给了消费者。



**使用topic，生产者发送100个消息到activeMQ，消费者接收100个消息。**

执行生产者后可以看到activeMQ的 Topics 中可以看到

```

Name ↑								Number Of Consumers  			Messages Enqueued  			Messages Dequeued  	
topic1										0								100							0

```

消费者启动后，可以看到上面变化如下：

```
Name ↑								Number Of Consumers  			Messages Enqueued  			Messages Dequeued  	
topic1										1								100							100
```

