package com.sawyer.controller;

import com.sawyer.entity.User;
import com.sawyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    public String login(User user, HttpSession session){
        User userDB = userService.login(user);
        if(userDB!=null){
            session.setAttribute("user",userDB);
            return "redirect:/file/showAll";
        }else{
            return "redirect:/index";
        }
    }
}
