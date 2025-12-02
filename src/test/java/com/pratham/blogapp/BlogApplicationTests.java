package com.pratham.blogapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BlogApplicationTests {

	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	void testSendMail() {
		
		redisTemplate.opsForValue().set("email","pratham@gmail");
		
		Object email=redisTemplate.opsForValue().get("email");
		
		int x=1;
		
	}

}
