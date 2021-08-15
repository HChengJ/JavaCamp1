使用shardingsphere-proxy版本是apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin。

使用数据库msyql8。

在shardingsphere-proxy启动后，测试2个分库，2个分表，增删改查都没有问题。

改成2个库16个表后，自动建16个表，和自动删16个表都没有问题，增加数据时报错。

改成16个表的配置为：

tables:
   t_order:
     actualDataNodes: ds_${0..15}.t_order_${0..15}

和

 t_order_inline:
     type: INLINE
     props:
       algorithm-expression: t_order_${order_id *10000/16/625}

