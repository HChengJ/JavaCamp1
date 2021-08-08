定义生成随机数据的存储过程：
DELIMITER $$

USE `electronic_commerce`$$

DROP PROCEDURE IF EXISTS `add_orders_memory`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_orders_memory`(IN n INT)
BEGIN
DECLARE i INT DEFAULT 1;
WHILE (i <= n ) DO
INSERT INTO `tf_c_orders_memory`  (user_id,good_id,amount,STATUS,create_time,update_time ) VALUES (i+100,i+100,0.25,1,NOW(),NOW() );
SET i=i+1;
END WHILE;
END$$

DELIMITER ;

生成100万数据：

CALL add_orders_memory(1000000)



以下为执行结果：


共 1 行受到影响

执行耗时   : 11.416 sec
传送时间   : 0 sec
总耗时      : 11.417 sec



方法一：将数据表中对应的数据插入指定表中，使用如下语句：


INSERT INTO `tf_c_orders`(user_id,good_id,amount,STATUS,create_time,update_time) SELECT user_id,good_id,amount,STATUS,create_time,update_time FROM  `tf_c_orders_memory`



以下为执行结果：

执行耗时   : 3.944 sec
传送时间   : 0 sec
总耗时      : 3.944 sec

执行时间3.9秒。





方法二：将`tf_c_orders_memory`  表中数据导出成一条条insert语句，存为执行1000000数据无id.sql，再用sqlyong打开，执行：

执行结果：
大概3分钟时提示内存不足，应用程序将关闭。。。



方法三：导出成excle文件，再使用sqlyog导入外部文件再使用语句将导入的临时表1111中数据插入指定表，导出数据65535条（excel文件默认）：

导出excel后，再使用sqlyog导入外部文件
SQLyog Job Agent v11.24 (32 bit) Copyright(c) Webyog Inc. All Rights Reserved.

Job started at Sun Aug 08 23:40:00 2021



DBMS Information: EXCEL


Importing table schema: 1111... Successful...

Importing table foreign keys: 1111... 

Importing table data: 1111... 

33519 rows transferred!

65535 rows transferred!

Successful...



Total time taken - 2 sec(s)




再次执行表之间数据复制插入，执行如下查询语句：
INSERT INTO `tf_c_orders`(user_id,good_id,amount,STATUS,create_time,update_time) SELECT user_id,good_id,amount,STATUS,create_time,update_time FROM  `1111`；


1 queries executed, 1 success, 0 errors, 0 warnings

查询：INSERT INTO `tf_c_orders`(user_id,good_id,amount,STATUS,create_time,update_time) SELECT user_id,good_id,amount,STATUS,create_tim...

共 65535 行受到影响

执行耗时   : 0.447 sec
传送时间   : 0 sec
总耗时      : 0.448 sec





总结：

方法一：使用时间3.944 sec。（推荐）

方法二：执行3分钟后，sqlyog客户端提示内存不足，应用程序将关闭。。。

方法三：需要分批处理excel文件，单个文件导入数据库需要 2 sec，再执行sql语句插入，使用0.447 sec



