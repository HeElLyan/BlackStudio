package ru.itis.blackstudio.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Integer roleId;
    private String phone;
    private String email;
    private String data;
    private Integer statusId;

    private List<Session> sessions;
    private List<Permission> permissions;

    public Integer getStatusId() {
        return statusId;
    }

    public User setStatusId(Integer statusId) {
        this.statusId = statusId;
        return this;
    }

    public Integer getRole() {
        return roleId;
    }

    public User setRole(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public User setSessions(List<Session> sessions) {
        this.sessions = sessions;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getData() {
        return data;
    }

    public User setData(String data) {
        this.data = data;
        return this;
    }



    public List<Permission> getPermissions() {
        return permissions;
    }

    public User setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", data='" + data + '\'' +
                ", statusId=" + statusId +
                ", permissions=" + permissions +
                '}';
    }

}
