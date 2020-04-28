package com.ananth.demo.dao;

import com.ananth.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserSQLDao implements UserDao {

    @Override
    public boolean insertUser(UUID uuid, User user) {
        return false;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserById(UUID uuid) {
        return Optional.empty();
    }
}
