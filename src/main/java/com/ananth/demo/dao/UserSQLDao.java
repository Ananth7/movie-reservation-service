package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.User;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserSQLDao implements UserDao {

    @Override
    public User insertUser(User user) {
        String addShowQuery = "insert into users (uuid, name, email, phone_number, is_admin "+
                ") values ('" + user.getUserID() + "', '" + user.getName() + "', '"
                + user.getEmailId() + "', '" + user.getPhoneNumber() + "','" + user.getIsAdmin() +  "');";
        System.out.println(addShowQuery);
        try {
            QueryExecutor.execWrites(addShowQuery);
            return  user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String getCitiesQuery = "select * from users;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<User> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                User user = User.builder()
                        .userID(resultSet.getString("uuid"))
                        .name(resultSet.getString("name"))
                        .emailId(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .isAdmin(resultSet.getInt("is_admin")).build();

                System.out.println(user);
                res.add(user);
            }
            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByEmail(String emailId) {
        String getCitiesQuery = "select * from users where user where email = " + emailId + ";";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);

            User user = null;
            while (resultSet.next()) {
                // retrieve and print the values for the current row
                user = User.builder()
                        .userID(resultSet.getString("uuid"))
                        .name(resultSet.getString("name"))
                        .emailId(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .isAdmin(resultSet.getInt("is_admin")).build();

                System.out.println(user);
            }
            resultSet.getStatement().getConnection().close();
            return user;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<User> getUserById(String userId) throws SQLException {
        String getUsersQuery = "select * from users where uuid = '" + userId + "';";
        System.out.println(getUsersQuery);
            ResultSet resultSet = QueryExecutor.execReads(getUsersQuery);

            User user = null;
            while (resultSet.next()) {
                // retrieve and print the values for the current row
                user = User.builder()
                        .userID(resultSet.getString("uuid"))
                        .name(resultSet.getString("name"))
                        .emailId(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .isAdmin(resultSet.getInt("is_admin")).build();

                System.out.println(user);
            }
            resultSet.getStatement().getConnection().close();
            return Optional.ofNullable(user);

    }
}
