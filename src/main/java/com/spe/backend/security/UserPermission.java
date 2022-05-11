package com.spe.backend.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum UserPermission {
    PROFILE_USER_ADD("profile_user:add"),
    PROFILE_USER_READ("profile_user:read"),
    PROFILE_USER_WRITE("profile_user:write"),
    PROJECT_USER_WRITE("project_user:write"),
    PROJECT_USER_UPDATE("project_user:update"),
    PROJECT_USER_DELETE("project_user:delete"),

    POST_USER_WRITE("post_user:write"),
    POST_USER_UPDATE("post_user:update"),
    POST_USER_DELETE("post_user:delete");

    private final String permission;
    UserPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}
