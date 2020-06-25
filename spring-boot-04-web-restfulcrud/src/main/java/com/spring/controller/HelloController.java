package com.spring.controller;

import com.spring.exception.UserNotExistException;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


    //    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "index";
//    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello";
    }


    //查询一些数据，在页面显示

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        //classpath:/templates/success.html
        return "success";
    }
}
