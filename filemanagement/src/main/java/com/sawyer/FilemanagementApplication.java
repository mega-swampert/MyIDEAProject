package com.sawyer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sawyer.dao")
public class FilemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilemanagementApplication.class, args);
    }

}
