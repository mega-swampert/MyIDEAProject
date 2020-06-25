package com.spring.controller;

import com.spring.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//浏览器和服务器都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public HashMap<String, Object> handlerException(Exception e){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code" ,"user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
//        需要传入自己的错误状态码4xx5xx
        /**
         * Integer statusCode = (Integer) request.getAttribute("javax".servlet.error.status_code)
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错了");
        request.setAttribute("ext", map);
//        将错误信息转发到/error
        return "forward:/error";
    }
}
