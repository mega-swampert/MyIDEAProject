package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync //开启异步注解

@EnableScheduling //开启定时注解
@SpringBootApplication
public class SpringBoot11TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot11TaskApplication.class, args);
    }

}
