package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04WebRestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
    }

    public ViewResolver myViewResolver() {
        return null;
    }

    private static class MyViewResolver implements ViewResolver {


        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
