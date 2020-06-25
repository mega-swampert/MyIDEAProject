package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String getTicket() {
        System.out.println("8002");
        return "《我买NMGB的票》";
    }
}
