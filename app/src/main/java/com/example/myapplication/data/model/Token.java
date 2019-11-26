package com.example.myapplication.data.model;

public class Token{

    String access_token;

    Token( String access_token ){
        this.access_token = access_token;
    }

    public String getAccessToken(){
        return access_token;
    }

    public void setAccessToken(String access_token ){
        this.access_token = access_token;
    }
}