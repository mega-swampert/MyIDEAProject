package com.spring.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spring.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("购票：" + ticket);

    }
}
