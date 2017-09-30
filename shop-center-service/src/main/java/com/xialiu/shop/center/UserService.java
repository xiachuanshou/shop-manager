package com.xialiu.shop.center;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.xialiu.shop.center.dao.user.entity.SpUser;
import com.xialiu.shop.center.dao.user.entity.SpUserExample;
import com.xialiu.shop.center.dao.user.mapper.SpUserMapper;
import com.xialiu.shop.center.dao.user.mapper.SpUserMapperExt;

@Service
public class UserService {
	@Autowired
	SpUserMapper spUserMapper;
	@Autowired
	SpUserMapperExt spUserMapperExt;
	
	/**
	 * 检查该属性是否已经被注册(用户名、电话、邮箱)
	 * @param condition
	 * @return
	 */
	public Boolean check(String condition){
		List<SpUser> dataList = spUserMapperExt.selectByCondition(condition);
		if(CollectionUtils.isEmpty(dataList)){
			return true;
		}
		return false;
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@Async
	public Future<Boolean> register(SpUser user){
		spUserMapper.insertSelective(user);
		return new AsyncResult<Boolean>(true);
	}
	
	/**
	 * 登录验证
	 * @param example
	 * @return
	 */
	public Boolean login(SpUserExample example){
		List<SpUser> dataList = spUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(dataList)){
			return false;
		}
		
		return true;
	}
}
