package com.spring.config;

import com.spring.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration当前类是配置类 ，用于代替之前的Spring配置文件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中的组件默认id是方法名   不需要导入Spring配置文件@ImportResource(locations = {"classpath:beans.xml"})
    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean给容器中添加组件了");
        return new HelloService();
    }

}
