package com.xialiu.shop.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xialiu.shop.center.UserService;
import com.xialiu.shop.center.dao.shop.entity.ManagerUserExample;
import com.xialiu.shop.exception.ErrorCode;
import com.xialiu.shop.exception.XiaLiuException;
import com.xialiu.shop.user.dto.UserDto;

@Service
public class UserBiz {
	@Autowired
	UserService userService;
	
	public Boolean login(UserDto userDto){
		if(userDto.getUserName() == null || userDto.getUserName().length() > 36){
			throw new XiaLiuException(ErrorCode.INVALID_PARAM, "userName = "+userDto.getUserName());
		}
		
		if(userDto.getPasswd() == null || userDto.getPasswd().length() > 36){
			throw new XiaLiuException(ErrorCode.INVALID_PARAM, "passwd = "+userDto.getPasswd());
		}
		
		ManagerUserExample example = new ManagerUserExample();
		example.createCriteria().andUsernameEqualTo(userDto.getUserName()).andUserpasswdEqualTo(userDto.getPasswd());
		return userService.login(example);
	}
}
