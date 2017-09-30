package com.xialiu.shop.center.dao.user.mapper;

import com.xialiu.shop.center.dao.user.entity.SpUser;
import java.util.List;

public interface SpUserMapperExt {
    List<SpUser> selectByCondition(String condition);
}