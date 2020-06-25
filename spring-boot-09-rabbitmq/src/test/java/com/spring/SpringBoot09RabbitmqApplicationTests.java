package com.spring;

import com.spring.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot09RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void creatExchange() {
//		创建exchange
//		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//		创建queue
//		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
//		绑定
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.zai", null));
    }

    /**
     * 1，单播点对点
     * 2，
     * 3，
     */
    @Test
    void contextLoads() {
//		message需要自己构造
//		rabbitTemplate.send(exchange,routeKey,message);
//		只需要传入要发送的对象，自动序列化送给rmq
//		rabbitTemplate.convertAndSend(exchange,routKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "first message");
        map.put("data", Arrays.asList("dfasa", 1233, true));
//		默认使用的是java的序列号方式发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "spring.news", new Book("aa", "bb"));
    }

    //	广播
    @Test
    void test02() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("西游记", "孙笑川"));
    }

    @Test
//	接收数据
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("spring.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
