package com.sawyer.controller;

import com.sawyer.entity.User;
import com.sawyer.service.UserService;
import com.sawyer.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(value = "/login")
    public String login(String username,String password,HttpSession session){
        User login = userService.login(username, password);
        if(login!=null){
            session.setAttribute("user",login);
            return "redirect:/emp/findAll";
        }else{
            return "redirect:/index";
        }
    }


    @PostMapping(value = "/register")
    public String register(User user,String code ,HttpSession session){
        String  code1 = (String) session.getAttribute("code");
        if(code1.equalsIgnoreCase(code)){
            userService.register(user);
            return "redirect:/index";
        }else {
            return "redirect:/toRegister";
        }

    }


    @GetMapping(value = "/code")
    public void getImg(HttpSession session, HttpServletResponse response) throws IOException {
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"jpg",os);
    }
}
