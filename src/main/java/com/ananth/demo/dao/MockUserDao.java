package com.ananth.demo.dao;

import com.ananth.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MockUserDao")
public class MockUserDao implements UserDao {

    private List<User> DB = new ArrayList<>();

    @Override
    public boolean insertUser(UUID uuid, User user) {
        DB.add(new User(uuid, user.getName(), user.getEmailId()));
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }
}
