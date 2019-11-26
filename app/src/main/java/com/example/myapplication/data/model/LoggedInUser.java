package com.example.myapplication.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String username;
    private Token token;

    public LoggedInUser(String username, Token token) {
        this.username = username;
        this.token = token;
    }

    public Token getToken(){ return token; }

    public String getUsername(){ return username; }

}
