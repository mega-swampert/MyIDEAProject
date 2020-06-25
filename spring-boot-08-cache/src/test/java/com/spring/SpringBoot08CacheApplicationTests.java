package com.spring;

import com.spring.bean.Employee;
import com.spring.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBoot08CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired//操作字符串
            StringRedisTemplate stringRedisTemplate;

    @Autowired//操作k-v
            RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    @Test
    public void test01() {
        //向msg保存数据
//		stringRedisTemplate.opsForValue().append("msg","qqqq");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);
//		stringRedisTemplate.opsForList().leftPush("mylist","1");
//		stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    @Test
    public void test02() {
        Employee get = employeeMapper.getEmpById(1);
        //默认如果保存对象，JDK序列化后的数据保存在redis
        redisTemplate.opsForValue().set("emp-01", get);
//		1将数据以json保存
//      2redistemplate默认的序列化
        employeeRedisTemplate.opsForValue().set("emp-01", get);

    }


    @Test
    void contextLoads() {
        Employee get = employeeMapper.getEmpById(1);
        System.out.println(get);
    }


}
