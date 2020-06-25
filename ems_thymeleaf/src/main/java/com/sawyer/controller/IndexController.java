package com.sawyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ValueExp;

/**
 * @author huanm
 * <p>
 * thymeleaf所有操作都需要通过controller实现跳转
 */
@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String toIndex() {
        return "ems/login";

    }

    @GetMapping(value = "/toRegister")
    public String toRegister() {
        return "ems/regist";
    }

    @GetMapping(value = "toSave")
    public String toSave() {
        return "ems/addEmp";
    }

}
