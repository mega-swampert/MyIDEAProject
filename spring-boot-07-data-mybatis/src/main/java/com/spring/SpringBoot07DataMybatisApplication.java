package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.spring.mapper")
@SpringBootApplication
public class SpringBoot07DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot07DataMybatisApplication.class, args);
    }

}
