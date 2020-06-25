package com.spring.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello....");
    }
}
