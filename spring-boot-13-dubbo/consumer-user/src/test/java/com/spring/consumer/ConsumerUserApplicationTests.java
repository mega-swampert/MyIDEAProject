package com.spring.consumer;

import com.spring.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {
    @Autowired
    ConsumerService consumerService;


    @Test
    void contextLoads() {
        consumerService.hello();
    }

}
