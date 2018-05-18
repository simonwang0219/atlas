package com.tju.wlq.dao;

import com.tju.wlq.entity.User;

import java.util.Set;

public interface UserDao {
    User getByUsername(String username);
    Set<String> getRoles(String username);
    Set<String> getPermissions(String username);
}
