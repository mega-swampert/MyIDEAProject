package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@DeleteMapping  @PutMapping  @GetMapping

    //以POST方式来限定一个请求
    //@RequestMapping(value="/user/login",method= RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        //添加错误消息
                        Map<String, Object> map,
                        //保存登陆用户的信息进session
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //将用户值放入
            session.setAttribute("loginUser", username);

            //登陆成功跳转到dashboard,要防止POST表单重复提交，可重定向到主页
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg", "密码错误");
            return "login";
        }
    }

}
