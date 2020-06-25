package com.sawyer.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    String  serverport;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul:"+serverport+"\t"+ UUID.randomUUID().toString();
    }

}
