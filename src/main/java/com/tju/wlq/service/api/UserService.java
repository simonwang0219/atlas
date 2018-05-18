package com.tju.wlq.service.api;

import com.tju.wlq.entity.User;

import java.util.Set;

public interface UserService {
    User getByUsername(String username);
    Set<String> getRoles(String username);
    Set<String> getPermissions(String username);
}
