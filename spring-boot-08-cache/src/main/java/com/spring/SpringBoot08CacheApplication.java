package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1，导入数据库文件
 * 2，创建bean封装数据
 * 3，整合Mybatis（1配置数据源信息 2注解mybatis[1@MapperScan指定需要扫描的mapper接口所在的包]）
 * <p>
 * 缓存（缓存注解）@EnableCaching
 */

@MapperScan("com.spring.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot08CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08CacheApplication.class, args);
    }

}
