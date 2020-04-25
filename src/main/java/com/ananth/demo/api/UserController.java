package com.ananth.demo.api;

import com.ananth.demo.model.Roles;
import com.ananth.demo.model.UserRole;
import com.ananth.demo.model.User;
import com.ananth.demo.request.RolesRequestBody;
import com.ananth.demo.service.RolesService;
import com.ananth.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Adduser:
 * {
 *     "name" : "",
 * }
 *
 * AddPartners:
 * {
 *     "userId"
 *     "theaterID"
 *     "RoleType"
 * }
 */

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;
    private final RolesService rolesService;

    @Autowired
    public UserController(UserService userService, RolesService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "{id}/roles")
    public void addUserRole(@PathVariable("id") UUID userId,
                            @RequestBody RolesRequestBody body) {
       rolesService.insertRole(new UserRole(userId,
               Roles.getIdByName(body.getRole()),
               body.getTheaterId()
               ));
    }

    @GetMapping(path = "/roles")
    public List<UserRole> getAllRoles() {
        return rolesService.getAllRoles();
    }

}
