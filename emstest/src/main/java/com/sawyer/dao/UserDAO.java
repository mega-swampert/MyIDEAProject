package com.sawyer.dao;

import com.sawyer.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    void save(User user);

    //传递多个参数需要绑定参数
    User login(@Param("username") String username, @Param("password") String password);
}
