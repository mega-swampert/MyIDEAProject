package com.sawyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public String toIndex(){
        return "/ems/login";
    }


    @GetMapping(value = "/toRegister")
    public String toRigest(){
        return "/ems/regist";
    }


    @GetMapping(value = "/toSave")
    public String toSave(){
        return "/ems/addEmp";
    }
}
