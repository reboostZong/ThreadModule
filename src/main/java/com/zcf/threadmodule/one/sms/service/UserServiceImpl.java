package com.zcf.threadmodule.one.sms.service;

import com.zcf.threadmodule.one.sms.dao.UserMapper;
import com.zcf.threadmodule.one.sms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
