package com.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot11TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;


    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		邮件设置
        simpleMailMessage.setSubject("通知");
        simpleMailMessage.setText("今晚不上班");
        simpleMailMessage.setTo("huanmiaoi@163.com");
        simpleMailMessage.setFrom("568422995@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    void text02() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//		复杂邮件设置
        helper.setSubject("通知");
        helper.setText("", "<b style='color:red'>今年休3个月</b>");
        helper.setTo("huanmiaoi@163.com");
        helper.setFrom("568422995@qq.com");

        //		上传文件
        helper.addAttachment("1.jpg", new File("D:\\Picture\\古剑三\\1.jpg"));
        helper.addAttachment("2.jpg", new File("D:\\Picture\\古剑三\\2.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
