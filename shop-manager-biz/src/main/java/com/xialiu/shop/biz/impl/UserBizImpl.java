package com.xialiu.shop.biz.impl;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.xialiu.shop.center.UserService;
import com.xialiu.shop.center.dao.user.entity.SpUserExample;

public class UserBizImpl {
	@Autowired
	UserService userService;
	
	public class UserLoginCallable implements Callable<Object>{
		public SpUserExample example;
		
		public UserLoginCallable(String userName, String password){
			example = new SpUserExample();
			example.createCriteria().andNameEqualTo(userName).andPasswordEqualTo(password);
		}

		@Override
		public Object call() throws Exception {
			return userService.login(example);
		}
	}
}
