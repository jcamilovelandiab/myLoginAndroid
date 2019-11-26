package com.example.myapplication.data.model;

public class User {

    private String username;
    private String password;

    public User(String password, String fullname){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }

}
