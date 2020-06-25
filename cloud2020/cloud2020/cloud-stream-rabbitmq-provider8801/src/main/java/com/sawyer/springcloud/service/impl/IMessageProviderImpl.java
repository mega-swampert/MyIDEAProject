package com.sawyer.springcloud.service.impl;

import com.sawyer.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;


//绑定接口的注解，不是@Service 定义消息的推送管道
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial"+serial);
        return null;
    }
}
