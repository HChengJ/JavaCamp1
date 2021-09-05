package com.hcj.pubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PubsubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsubApplication.class, args);
		JedisPool jedisPool = new JedisPool();
		String channelName = "ORDER";

		SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
		PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
	}

}
