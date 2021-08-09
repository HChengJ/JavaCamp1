package com.hcj.abstractrouting;

import com.hcj.abstractrouting.entity.TfCUser;
import com.hcj.abstractrouting.service.TfCUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class AbstractroutingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TfCUserService userService;

	@Test
	public void test() {
		TfCUser user = userService.findUserByFirstDb(1);
		log.info("第一个数据库 : [{}]", user.toString());
		TfCUser user2 = userService.findUserBySecondDb(1);
		log.info("第二个数据库 : [{}]", user2.toString());
	}
}
