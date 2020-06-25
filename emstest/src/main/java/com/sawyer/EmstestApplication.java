package com.sawyer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.sawyer.dao")
@SpringBootApplication
public class EmstestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmstestApplication.class, args);
    }

}
