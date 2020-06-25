package com.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@EnableRabbit//开启注解rabbitmq
@SpringBootApplication
public class SpringBoot09RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09RabbitmqApplication.class, args);
    }

}
