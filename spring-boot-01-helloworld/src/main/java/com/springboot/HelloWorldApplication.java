package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springbootapplication标注一个主程序类，说明这是springboot应用
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        //启动Spring 参数1启动类，该类必须是SpringBootApplication标注的类   参数2 主方法参数
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
