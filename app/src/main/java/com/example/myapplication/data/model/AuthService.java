package com.example.myapplication.data.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/auth")
    Call<Token> login(@Body User login);
}