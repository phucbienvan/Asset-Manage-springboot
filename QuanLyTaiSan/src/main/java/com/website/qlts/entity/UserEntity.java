package com.website.qlts.entity;

import java.util.Collection;

public class UserEntity {
    private long id;
    private String userName;
    private String password;
    private Collection<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public UserEntity(long id, String userName, String password, Collection<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
