package com.sawyer.service;

import com.sawyer.entity.User;

public interface UserService {
    void register(User user);
    User login(String username ,String password);
}
