package com.ananth.demo.service;

import com.ananth.demo.dao.UserDao;
import com.ananth.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(String id) throws SQLException {
        return userDao.getUserById(id);
    }

    public void deleteUserById(String id) {

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
