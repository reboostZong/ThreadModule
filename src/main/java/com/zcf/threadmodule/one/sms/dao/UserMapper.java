package com.zcf.threadmodule.one.sms.dao;

import com.zcf.threadmodule.one.sms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);
}
