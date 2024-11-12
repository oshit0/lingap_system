package com.lingapms.model;

import com.lingapms.enums.Role;

public class User{
    private int id;
    private String username;
    private String password;
    private int userId;
    private Role role;

    public User(){
    }

    public User(String username, String password, int userId, Role role){
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.role = role;
    }

    public User(int id, String username, String password, Role role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId(){
        return id;
    }

    public int setId(int id){
        return this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "username='" + username + '\'' +
                "user_id='" + userId + '\'' +
                ", role=" + role +
                '}';
    }
}

