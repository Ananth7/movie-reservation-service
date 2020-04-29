package com.ananth.demo.dao;

import com.ananth.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDao implements UserDao {

    private List<User> DB = new ArrayList<>();

    @Override
    public User insertUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
