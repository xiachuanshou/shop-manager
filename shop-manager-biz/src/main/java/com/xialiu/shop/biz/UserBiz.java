package com.xialiu.shop.biz;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.xialiu.shop.async.AsyncUtils;
import com.xialiu.shop.center.UserService;
import com.xialiu.shop.center.dao.user.entity.SpUser;
import com.xialiu.shop.center.dao.user.entity.SpUserExample;
import com.xialiu.shop.redis.dao.RedisDao;
import com.xialiu.shop.user.dto.UserDto;

@Service
public class UserBiz {
	@Autowired
	UserService userService;
	@Autowired
	RedisDao redisDao;
	
	@Resource(name="taskExecutor")
	ThreadPoolTaskExecutor pool;
	
	private Logger logger = LoggerFactory.getLogger(UserBiz.class);
	
	public Boolean check(String condition){
		if(condition == null || condition.equals("")){
			return false;
		}
		
		return userService.check(condition);
	}
	
	public Boolean register(UserDto userDto){
		SpUser user = new SpUser();
		BeanUtils.copyProperties(userDto, user);
	
		Future<Boolean> registerAsync =  userService.register(user);
		return AsyncUtils.getAynscResult(2000, registerAsync, false);
		//return userService.register(user);
	}
	
	public Boolean login(UserDto userDto){
		//用户登录是否成功
		try {
			//ExecutorService pool = Executors.newFixedThreadPool(1);
			//UserBizImpl.UserLoginCallable userLoginCallable = new UserBizImpl().new UserLoginCallable(userDto.getName(), userDto.getPassword());
			UserLoginCallable userLoginCallable = new UserLoginCallable(userDto.getName(), userDto.getPassword());
			Future<Object> userLoginFuture = pool.submit(userLoginCallable);
			
			boolean isLogin =  (Boolean) userLoginFuture.get();
			//pool.shutdown();
			return isLogin;
		} catch (Exception e) {
			logger.error("用户:{} 登录异常 : ", userDto.getName(), e);
			return false;
		}
	}
	
	class UserLoginCallable implements Callable<Object>{
		private String userName;
		private String password;
		
		public UserLoginCallable(String userName, String password) {
			this.userName = userName;
			this.password = password;
		}
		
		@Override
		public Object call() throws Exception {
			SpUserExample example = new SpUserExample();
			example.createCriteria().andNameEqualTo(userName).andPasswordEqualTo(password);
			return userService.login(example);
		}
		
	}
}
