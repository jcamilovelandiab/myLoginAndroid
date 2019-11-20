package com.example.myapplication.data.model;

public class User {

    private String username;
    private String password;
    private String userId;
    private String fullname;

    public User(){}

    public User(String userId, String username, String password, String fullname){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public String getUserId(){ return this.userId; }
    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }
    public String getFullname(){ return this.fullname; }

    public void setUserId(String userId){ this.userId = userId; }
    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }
    public String setFullname(String fullname){ return this.fullname = fullname; }

}
