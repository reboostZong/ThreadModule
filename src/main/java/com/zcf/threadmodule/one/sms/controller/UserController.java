package com.zcf.threadmodule.one.sms.controller;

import com.zcf.threadmodule.one.sms.pojo.User;
import com.zcf.threadmodule.one.sms.service.UserService;
import com.zcf.threadmodule.one.sms.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String registeUser(User user) {
        long start = System.currentTimeMillis();
        userService.insert(user);
        long time = System.currentTimeMillis() - start;
        return "Success: " + time;
    }

    @PostMapping("/sms/user")
    public String registeUserBySms(User user) {
        long start = System.currentTimeMillis();
        userService.insert(user);
        //线程应用在短信发送场景, 优化请求时间
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.execute(()->{
            SmsUtils.sendSms("158888888");
        });
        long time = System.currentTimeMillis() - start;
        return "Success: " + time;
    }
}
