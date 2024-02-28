package com.itzone.itzone.common;

import lombok.Getter;

@Getter
public enum UserRole {
    USER(Role.USER),
    ADMIN(Role.ADMIN);

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public static class Role {
        public static final String USER = "USER";
        public static final String ADMIN = "ADMIN";
    }
}
