package com.ananth.demo.service;

import com.ananth.demo.dao.RoleDao;
import com.ananth.demo.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    private RoleDao roleDao;

    public RolesService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public boolean insertRole(UserRole userRole) {
        roleDao.insertRole(userRole);
        return true;
    }

    public List<UserRole> getAllRoles() {
        return roleDao.getRoles();
    }
}
