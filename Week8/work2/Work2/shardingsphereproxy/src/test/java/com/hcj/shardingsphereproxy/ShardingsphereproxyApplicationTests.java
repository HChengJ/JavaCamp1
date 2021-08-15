package com.hcj.shardingsphereproxy;

import com.hcj.shardingsphereproxy.entity.Order;
import com.hcj.shardingsphereproxy.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingsphereproxyApplicationTests {
	@Autowired
	private OrderService orderService;
	@Test
	void contextLoads() {
	}

	@Test
	public void testAdd(){
		Order order = new Order();
		order.setUserId(5);
		order.setStatus("OK");
		orderService.insert(order);
	}

	@Test
	public void testQuery(){

		Order order = orderService.queryById(633789000372957185L);
		System.out.println(order.toString());
	}

	@Test
	public void testUpdate(){
	//[Can not update sharding key, logic table: [t_order], column: [user_id].]; nested exception is java.sql.SQLException:
	// 2Unknown exception: [Can not update sharding key, logic table: [t_order], column: [user_id].]
	//at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:92)
//		Order order = orderService.queryById(633789000372957185L);
//		System.out.println("修改前："+order.toString());
//		order.setStatus("upate");
//		orderService.update(order);
//		System.out.println("修改前："+order.toString());
	}

	@Test
	public void testDelete(){
		Order order = orderService.queryById(  633808776356933632L);
		orderService.deleteById(633808776356933632L);
		Order order1 = orderService.queryById( 633808776356933632L);
		System.out.println(order1 == null ? "删除成功" : "删除失败");
	}
}
