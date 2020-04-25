package com.ananth.demo.dao;

import com.ananth.demo.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockRolesDao implements RoleDao {

    private List<UserRole> DB = new ArrayList<>();

    @Override
    public boolean insertRole(UserRole userRole) {
        DB.add(new UserRole(userRole.getUserId(), userRole.getRoleId(), userRole.getTheaterId()));
        return true;
    }

    @Override
    public List<UserRole> getRoles() {
        return DB;
    }
}
