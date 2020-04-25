package com.ananth.demo.dao;

import com.ananth.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    boolean insertUser(UUID uuid, User user);

    default boolean insertUser(User user) {
        final UUID uuid = UUID.randomUUID();
        return insertUser(uuid, user);
    }

    List<User> getAllUsers();

}
