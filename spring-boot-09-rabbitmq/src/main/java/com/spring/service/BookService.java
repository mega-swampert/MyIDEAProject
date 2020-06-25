package com.spring.service;

import com.spring.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "sawyer.news")
    public void receive(Book book) {
        System.out.println("收到消息:" + book);
    }
}
