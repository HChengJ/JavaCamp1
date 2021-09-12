23-Work1

1、下载window版本redis：Redis-x64-3.2.100，解压后文件夹重命名为Redis-x64-3.2.100_1，复制一份文件夹命名为Redis-x64-3.2.100_2。

2、修改Redis-x64-3.2.100_2配置文件redis.windows.conf中端口6379为6380，在端口下使用命令：slaveof 127.0.0.1 6379 设置为从机。

3、启动主机，在Redis-x64-3.2.100_1文件夹下打开命令行，执行命令： redis-server redis.windows.conf，看到Server started, Redis version 3.2.100说明主Reidis启动完成。

4、启动从机，在Redis-x64-3.2.100_2文件夹下打开命令行，执行命令： redis-server redis.windows.conf，看到命令行中提示如下：

```
 The server is now ready to accept connections on port 6380
 Connecting to MASTER 127.0.0.1:6379
 MASTER <-> SLAVE sync started
 Non blocking connect for SYNC fired the event.
 Master replied to PING, replication can continue...
 Partial resynchronization not possible (no cached master)
 Full resync from master: c06a7132dacdf7ad063abee6d40c6999d9bbc181:1
 MASTER <-> SLAVE sync: receiving 75 bytes from master
 MASTER <-> SLAVE sync: Flushing old data
 MASTER <-> SLAVE sync: Loading DB in memory
 MASTER <-> SLAVE sync: Finished with success
```

同时主机命令行中也同时显示，如下：

```
The server is now ready to accept connections on port 6379
Slave 127.0.0.1:6380 asks for synchronization
Full resync requested by slave 127.0.0.1:6380
Starting BGSAVE for SYNC with target: disk
Background saving started by pid 15808
fork operation complete
Background saving terminated with success
Synchronization with slave 127.0.0.1:6380 succeeded
```

5、测试主机写，在文件夹Redis-x64-3.2.100_1下，打开新的命令行，执行命令：redis-cli，出现 “127.0.0.1:6379> ”后，在气候设置key=a，value=111；key=b，value=222。

6、在从机上获取已写的key，如下：

```
F:\IdeaWorkSpace\JavaCamp1\Week12\Work\Wok1\Redis-x64-3.2.100_2>redis-cli
127.0.0.1:6379> get a
"111"
127.0.0.1:6379> get b
"222"
127.0.0.1:6379> keys *
1) "b"
2) "a"
```

以上说明主从复制没有问题



7、Redis-x64-3.2.100_1配置sentinel.conf文件，内容如下：

```
port 26379
#下面两行注释掉了，是因为低版本redis不支持这两个命令
#sentinel myid fad25e089080be8dddadd3f20e44f888b1f8d48a
#sentinel deny-scripts-reconfig yes
sentinel monitor mymaster 127.0.0.1 6379 2
sentinel down-after-milliseconds mymaster 10000
sentinel failover-timeout mymaster 15000
```

8、Redis-x64-3.2.100_2配置sentinel.conf文件，内容如下：

```
port 26380
#下面两行注释掉了，是因为低版本redis不支持这两个命令
#sentinel myid fad25e089080be8dddadd3f20e44f888b1f8d48b
#sentinel deny-scripts-reconfig yes
sentinel monitor mymaster 127.0.0.1 6379 2
sentinel down-after-milliseconds mymaster 10000
sentinel failover-timeout mymaster 15000
```

9、Redis-x64-3.2.100_1使用命令行执行命令：redis-server redis.windows.conf 启动reids。

10、Redis-x64-3.2.100_2,使用命令行执行命令：redis-server redis.windows.conf 启动reids。

11、Redis-x64-3.2.100_1使用命令行执行命令：redis-server sentinel.conf --sentinel，启动哨兵，完成后如下：

```
Sentinel ID is 0a029bf8af10d619074b3b6b574bf345cc7915b6
+monitor master mymaster 127.0.0.1 6379 quorum 2
+slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+sdown sentinel 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 127.0.0.1 26380 @ mymaster 127.0.0.1 6379
+sdown sentinel 96e372775e0f2fb7fb9df6d594c50f80b824f322 127.0.0.1 0 @ mymaster 127.0.0.1 6379
-sdown sentinel 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 127.0.0.1 26380 @ mymaster 127.0.0.1 6379
```

11、Redis-x64-3.2.100_2使用命令行执行命令：redis-server sentinel.conf --sentinel，启动哨兵，完成后如下：

```
 Sentinel ID is 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f
 +monitor master mymaster 127.0.0.1 6379 quorum 2
 +slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
```

12、测试主从切换，停止主机redis服务。此时超过哨兵配置的15秒后，从机成为主机。

```
 MASTER <-> SLAVE sync started
 Discarding previously cached master state.
 MASTER MODE enabled (user request from 'id=5 addr=127.0.0.1:7216 fd=10 name=sentinel-77f4a9e1-cmd age=192 idle=0 flags=x
uf=0 qbuf-free=32768 obl=36 oll=0 omem=0 events=r cmd=exec')
 CONFIG REWRITE executed with success.
```

此时说明切换成功



13、启动已经停掉的主机redis服务，可以看到如下提示：

```
 Server started, Redis version 3.2.100
 DB loaded from disk: 0.000 seconds
 The server is now ready to accept connections on port 6379
 SLAVE OF 127.0.0.1:6380 enabled (user request from 'id=2 addr=127.0.0.1:14375 fd=7 name=sentinel-0a029bf8-cmd age=10 i
 multi=3 qbuf=0 qbuf-free=32768 obl=36 oll=0 omem=0 events=r cmd=exec')
 CONFIG REWRITE executed with success.
 Connecting to MASTER 127.0.0.1:6380
 MASTER <-> SLAVE sync started
 Non blocking connect for SYNC fired the event.
 Master replied to PING, replication can continue...
 Partial resynchronization not possible (no cached master)
 Full resync from master: 7b6c5322d6631b44e6ab1472a096edf3bc342bfc:1
 MASTER <-> SLAVE sync: receiving 91 bytes from master
 MASTER <-> SLAVE sync: Flushing old data
 MASTER <-> SLAVE sync: Loading DB in memory
 MASTER <-> SLAVE sync: Finished with success
```

说明新加入的redis已经加入到集群中，是从机。

14、切换期间原主机哨兵命令行提示如下：

```
 Sentinel ID is 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f
 +monitor master mymaster 127.0.0.1 6379 quorum 2
 +slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
 +sdown master mymaster 127.0.0.1 6379
 +odown master mymaster 127.0.0.1 6379 #quorum 2/2
 +new-epoch 1
 +try-failover master mymaster 127.0.0.1 6379
 +vote-for-leader 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 1
 0a029bf8af10d619074b3b6b574bf345cc7915b6 voted for 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 1
 +elected-leader master mymaster 127.0.0.1 6379
 +failover-state-select-slave master mymaster 127.0.0.1 6379
 +selected-slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
 +failover-state-send-slaveof-noone slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
 +failover-state-wait-promotion slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
 +promoted-slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
 +failover-state-reconf-slaves master mymaster 127.0.0.1 6379
 +failover-end master mymaster 127.0.0.1 6379
 +switch-master mymaster 127.0.0.1 6379 127.0.0.1 6380
 +slave slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
 +sdown slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
 -sdown slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
```

切换期间原从机哨兵命令行提示如下：

```
Sentinel ID is 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f
+monitor master mymaster 127.0.0.1 6379 quorum 2
+slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+sdown master mymaster 127.0.0.1 6379
+odown master mymaster 127.0.0.1 6379 #quorum 2/2
+new-epoch 1
+try-failover master mymaster 127.0.0.1 6379
+vote-for-leader 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 1
0a029bf8af10d619074b3b6b574bf345cc7915b6 voted for 77f4a9e13657cd1ce48e2a3233bf3d0e4acf051f 1
+elected-leader master mymaster 127.0.0.1 6379
+failover-state-select-slave master mymaster 127.0.0.1 6379
+selected-slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+failover-state-send-slaveof-noone slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+failover-state-wait-promotion slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+promoted-slave slave 127.0.0.1:6380 127.0.0.1 6380 @ mymaster 127.0.0.1 6379
+failover-state-reconf-slaves master mymaster 127.0.0.1 6379
+failover-end master mymaster 127.0.0.1 6379
+switch-master mymaster 127.0.0.1 6379 127.0.0.1 6380
+slave slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
+sdown slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
-sdown slave 127.0.0.1:6379 127.0.0.1 6379 @ mymaster 127.0.0.1 6380
```

