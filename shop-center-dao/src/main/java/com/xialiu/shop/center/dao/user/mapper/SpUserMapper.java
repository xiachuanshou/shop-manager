package com.xialiu.shop.center.dao.user.mapper;

import com.xialiu.shop.center.dao.user.entity.SpUser;
import com.xialiu.shop.center.dao.user.entity.SpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpUserMapper {
    int countByExample(SpUserExample example);

    int deleteByExample(SpUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpUser record);

    int insertSelective(SpUser record);

    List<SpUser> selectByExample(SpUserExample example);

    SpUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpUser record, @Param("example") SpUserExample example);

    int updateByExample(@Param("record") SpUser record, @Param("example") SpUserExample example);

    int updateByPrimaryKeySelective(SpUser record);

    int updateByPrimaryKey(SpUser record);
}