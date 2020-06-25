package com.sawyer.serviceImpl;

import com.sawyer.dao.UserDAO;
import com.sawyer.entity.User;
import com.sawyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {

        return  userDAO.login(username,password);
    }
}
