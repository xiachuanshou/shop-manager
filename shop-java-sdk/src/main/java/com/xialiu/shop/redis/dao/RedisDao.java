package com.xialiu.shop.redis.dao;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisDao {
	@Resource( name = "redisTemplate")
	RedisTemplate<String, Object> redisTemplate;
	
	public void add(String key, Object value, long data, int timeType){//data为在redis存储有效时间
		Object type = null;
		switch (timeType) {
		case 0:
			type = TimeUnit.MINUTES;
			break;
		case 1:
			type = TimeUnit.HOURS;
			break;
		case 2:
			type = TimeUnit.DAYS;
		}
		redisTemplate.opsForValue().set(key, value, data, (TimeUnit)type);
	}
	
	public Object get(String key){
		return redisTemplate.opsForValue().get(key);
	}
}
