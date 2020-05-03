package com.ananth.demo.dao;

import com.ananth.demo.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    User insertUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(String userId) throws SQLException;

    User getUserByEmail(String emailId);
}
