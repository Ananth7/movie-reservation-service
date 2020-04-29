package com.ananth.demo.dao;

import com.ananth.demo.model.User;

import java.util.List;

public interface UserDao {

    User insertUser(User user);

    List<User> getAllUsers();

}
