package com.sawyer.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String serverport;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookkeeper:"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
