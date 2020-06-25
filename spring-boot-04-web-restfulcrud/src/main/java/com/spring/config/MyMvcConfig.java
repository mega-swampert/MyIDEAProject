package com.spring.config;


import com.spring.component.LoginHandlerInterceptor;
import com.spring.component.MyLocaleReolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //浏览器发送/spring请求来到success
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/spring").setViewName("success");
    }

    //所有的WebMvcConfigurer组件会一起起作用
    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer1 = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //登陆成功后需要经过模板引擎解析，可以添加视图映射，将main主页重定向到dashboard.html
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器处理登陆请求，所有都拦截，除了登录页面和登陆请求
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //添加一个拦截器，new登陆拦截器
                //静态资源：css js  springboot已经做好了静态资源的映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        //
//                        excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return configurer1;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleReolver();
    }
}
