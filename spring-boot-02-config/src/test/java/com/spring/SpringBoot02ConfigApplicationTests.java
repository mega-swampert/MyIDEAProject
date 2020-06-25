package com.spring;

import com.spring.bean.Person;
import com.spring.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring单元测试
 * 可以再测试期间方便的类似代码一样进行自动注入等容器的功能
 */

@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloService() {
        Boolean b = ioc.containsBean("helloService02");
        System.out.println(b);
    }
}
