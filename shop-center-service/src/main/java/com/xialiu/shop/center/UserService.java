package com.xialiu.shop.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.xialiu.shop.center.dao.shop.entity.ManagerUser;
import com.xialiu.shop.center.dao.shop.entity.ManagerUserExample;
import com.xialiu.shop.center.dao.shop.mapper.ManagerUserMapper;

@Service
public class UserService {
	@Autowired
	ManagerUserMapper managerUserMapper;
	
	public Boolean login(ManagerUserExample example){
		List<ManagerUser> dataList = managerUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(dataList)){
			return false;
		}
		
		return true;
	}
}
