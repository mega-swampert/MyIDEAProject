package com.sawyer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sawyer.dao.UserDAO;
import com.sawyer.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.element.VariableElement;
import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    UserDAO userDAO;

    @Test
    void testFindAll(){
        List<User> users = userDAO.selectList(null);
        users.forEach(user -> System.out.println("user = "+user));
    }


    @Test
    void testFindById(){
        User user = userDAO.selectById("2");
        System.out.println("user = " +user);
    }

    /**
     * 条件查询
     */
    @Test
    void testFind(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //eq等值查询  lt小于查询  le小于等于 gt大于查询 ge大于等于
        queryWrapper.eq("age",11);
        List<User> user = userDAO.selectList(queryWrapper);
        System.out.println(user);

    }

    @Test
    void testFindLike(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //like %？% likeLeft %?结尾  likeRight ?%开头
        queryWrapper.like("username" ,"a");
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user -> System.out.println("user = "+user));
    }


}
