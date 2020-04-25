package com.ananth.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Roles {

    public static Map<String, Integer> RolesToIntMapping = new HashMap<>();

    static {
        RolesToIntMapping.put("THEATER_OWNER", 1);
        RolesToIntMapping.put("SYS_ADMIN", 2);
    }

    public static int getIdByName(final String role) {
        return RolesToIntMapping.getOrDefault(role, -1);
    }
}
