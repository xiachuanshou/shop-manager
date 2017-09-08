package com.xialiu.shop.center.dao.shop.mapper;

import com.xialiu.shop.center.dao.shop.entity.ManagerUser;
import com.xialiu.shop.center.dao.shop.entity.ManagerUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerUserMapper {
    int countByExample(ManagerUserExample example);

    int deleteByExample(ManagerUserExample example);

    int insert(ManagerUser record);

    int insertSelective(ManagerUser record);

    List<ManagerUser> selectByExample(ManagerUserExample example);

    int updateByExampleSelective(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByExample(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);
}