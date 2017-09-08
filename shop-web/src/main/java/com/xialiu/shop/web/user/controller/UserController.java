package com.xialiu.shop.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xialiu.shop.biz.UserBiz;
import com.xialiu.shop.common.dto.Result;
import com.xialiu.shop.user.dto.UserDto;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserBiz UserBiz;
	
	@RequestMapping("login")
	@ResponseBody
	public Result<Boolean> login(UserDto userDto){
		Boolean data = UserBiz.login(userDto);
		return new Result<Boolean>().success(data);
	}
}
