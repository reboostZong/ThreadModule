package com.zcf.threadmodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zcf.threadmodule.one.sms.dao")
@SpringBootApplication
public class ThreadModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadModuleApplication.class, args);
    }

}
