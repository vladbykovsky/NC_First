package com.netcracker.edu.vlad.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int userId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Role rolesByRoleId;

    User(){
    }

    User(int userId, String login, String password, String name, String surname, String email, String address, Role rolesByRoleId){
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.address = address;
        this.rolesByRoleId = rolesByRoleId;
    }

    public Role getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Role rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", rolesByRoleId=" + rolesByRoleId +
                '}';
    }
}
