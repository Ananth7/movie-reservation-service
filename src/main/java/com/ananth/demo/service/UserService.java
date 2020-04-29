package com.ananth.demo.service;

import com.ananth.demo.dao.UserDao;
import com.ananth.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user) {
        userDao.insertUser(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
