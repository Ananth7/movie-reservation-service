package com.ananth.demo.dao;

import com.ananth.demo.model.UserRole;

import java.util.List;

public interface RoleDao {
    boolean insertRole(UserRole userRole);
    List<UserRole> getRoles();
}
