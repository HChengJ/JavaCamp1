**单机测试**

1、下载kafka_2.12-2.8.0，jdk版本11.0.11，系统win7 x64。

2、修改server.properties配置 #listeners=PLAINTEXT://:9092 为：listeners=PLAINTEXT://localhost:9092

3、命令行下，执行：kafka_2.12-2.8.0_1\bin\windows>zookeeper-server-start.bat ..\\..\config\zookeeper.properties。

4、命令行下，执行：kafka_2.12-2.8.0_1\bin\windows>kafka-server-start.bat ..\\..\config\server.properties 。

5、测试：

​	创建名称为test1的topic，如下：

kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test1
Created topic test1.

​	查看所有topic,如下：

kafka-topics.bat --zookeeper localhost:2181 --list

test1

​	查看topic的配置,如下：

kafka-topics.bat --zookeeper localhost:2181 --describe --topic test1

Topic: test1 TopicId: U44N5IFwSQi1m1Ue5izVRQ PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: test1 Partition: 0    Leader: 0       Replicas: 0     Isr: 0

​	创建消费者：

kafka-console-consumer.bat --bootstrap-server localhost:9092 --from-beginning --topic test1

​	创建生产者：

kafka-console-producer.bat --bootstrap-server localhost:9092 --topic test1

在生产者中输入：hello,java

在消费者自动输出	hello,java

以上说明单机Kafaka启动成功。



**集群测试**

1、修改配置文件：

kafka_2.12-2.8.0_1中

broker.id=0为：broker.id=1

#listeners=PLAINTEXT://:9092 为：listeners=PLAINTEXT://localhost:9091

log.dirs=/tmp/kafka-logs为：log.dirs=./kafka-logs-1

#advertised.listeners=PLAINTEXT://your.host.name:9092 为： advertised.listeners=PLAINTEXT://localhost:9091

增加：broker.list=localhost:9001,localhost:9002,localhost:9003



kafka_2.12-2.8.0_2中

broker.id=0为：broker.id=2

#listeners=PLAINTEXT://:9092 为 listeners=PLAINTEXT://localhost:9092

#advertised.listeners=PLAINTEXT://your.host.name:9092 为： advertised.listeners=PLAINTEXT://localhost:9092

log.dirs=/tmp/kafka-logs 为：log.dirs=./kafka-logs-2

增加：broker.list=localhost:9001,localhost:9002,localhost:9003



kafka_2.12-2.8.0_3中

broker.id=0为：broker.id=3

#listeners=PLAINTEXT://:9092 为 listeners=PLAINTEXT://localhost:9093

#advertised.listeners=PLAINTEXT://your.host.name:9092 为： advertised.listeners=PLAINTEXT://localhost:9093

log.dirs=/tmp/kafka-logs 为：log.dirs=./kafka-logs-3

增加：broker.list=localhost:9001,localhost:9002,localhost:9003



2、启动集群：

​	使用ZooInspector工具清理zookeeper，下载https://issues.apache.org/jira/secure/attachment/12436620/ZooInspector.zip，完成后，

​	使用 java -jar zookeeper-dev-ZooInspector.jar命令启动ZooInspector图形化界面，在界面中查看是否有zookeeper之外的节点，有就删除，没有就不管。



​	启动kafka_2.12-2.8.0_1：

​		kafka_2.12-2.8.0_1\bin\windows>kafka-server-start.bat ..\\..\config\server.properties 

​	启动kafka_2.12-2.8.0_2：

​		kafka_2.12-2.8.0_2\bin\windows>kafka-server-start.bat ..\\..\config\server.properties 

​	启动kafka_2.12-2.8.0_3：

​		kafka_2.12-2.8.0_3\bin\windows>kafka-server-start.bat ..\\..\config\server.properties 



3、测试集群：

​	创建topic

kafka_2.12-2.8.0_3\bin\windows>kafka-topics.bat --zookeeper localhost:2181 --create --topic test32 --partitions 3 --replication-factor 2

Created topic test32.

​	查看topic配置：

kafka-topics.bat --zookeeper localhost:2181 --describe --topic test32

Topic: test32   TopicId: W0XfbELeRZOj7_LmMUivtA PartitionCount: 3       ReplicationFactor: 2    Configs:
        Topic: test32   Partition: 0    Leader: 3       Replicas: 3,2   Isr: 3,2
        Topic: test32   Partition: 1    Leader: 1       Replicas: 1,3   Isr: 1,3
        Topic: test32   Partition: 2    Leader: 2       Replicas: 2,1   Isr: 2,1

​	

​	打开生产者控制台：

kafka-console-producer.bat --bootstrap-server localhost:9092,localhost:9093 --topic test32

​	打开消费者控制台：

kafka-console-consumer.bat --bootstrap-server localhost:9092,localhost:9093 --topic test32



此时在生产者控制台中输入字符串，在消费者控制台中可以接收



4、集群性能测试：

​	使用命令：

kafka-producer-perf-test.bat --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9092

显示如下：

9870 records sent, 1973.6 records/sec (1.88 MB/sec), 57.7 ms avg latency, 513.0 ms max latency.
10097 records sent, 2018.6 records/sec (1.93 MB/sec), 12.1 ms avg latency, 88.0 ms max latency.
10055 records sent, 2009.0 records/sec (1.92 MB/sec), 6.7 ms avg latency, 65.0 ms max latency.
10062 records sent, 2012.4 records/sec (1.92 MB/sec), 15.3 ms avg latency, 340.0 ms max latency.
9721 records sent, 1940.7 records/sec (1.85 MB/sec), 2.7 ms avg latency, 152.0 ms max latency.
10476 records sent, 2095.2 records/sec (2.00 MB/sec), 7.2 ms avg latency, 243.0 ms max latency.
10011 records sent, 2001.4 records/sec (1.91 MB/sec), 2.2 ms avg latency, 47.0 ms max latency.
10004 records sent, 2000.8 records/sec (1.91 MB/sec), 1.4 ms avg latency, 40.0 ms max latency.
10006 records sent, 2000.8 records/sec (1.91 MB/sec), 1.3 ms avg latency, 34.0 ms max latency.
100000 records sent, 1999.240289 records/sec (1.91 MB/sec), 10.69 ms avg latency, 513.00 ms max latency, 2 ms 50th, 37 ms 95th, 223 ms 99th, 481 ms 99.9th.

