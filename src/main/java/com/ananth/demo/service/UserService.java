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

    public User addUser(User user) {
        return userDao.insertUser(user);
    }

    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    public void deleteUserById(String id) {

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
