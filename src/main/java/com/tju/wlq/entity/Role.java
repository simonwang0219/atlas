package com.tju.wlq.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private int id;
    private String roleName;
    private List<Permission> permissionList;
    private List<User> userList;
}
