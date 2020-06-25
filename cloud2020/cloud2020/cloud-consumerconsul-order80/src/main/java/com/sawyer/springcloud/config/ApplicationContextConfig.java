package com.sawyer.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public  RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
