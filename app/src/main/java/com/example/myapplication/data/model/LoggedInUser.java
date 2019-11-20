package com.example.myapplication.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String username;
    private String displayName;

    public LoggedInUser(String userId, String username) {
        this.userId = userId;
        //this.displayName = displayName;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUsername(){ return username; }

}
