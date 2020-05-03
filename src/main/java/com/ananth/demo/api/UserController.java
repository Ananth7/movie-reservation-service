package com.ananth.demo.api;

import com.ananth.demo.model.User;
import com.ananth.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("api/v1/user")
    @ResponseBody
    public User addUser(@Valid @NonNull @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("api/v1/user/{userId}")
    public User getUserById(@PathVariable("userId") String id) {
        try {

            Optional<User> userById = userService.getUserById(id);
            if (userById.isPresent()) return userById.get();
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Invalid user!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/api/v1/user/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("api/v1/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
