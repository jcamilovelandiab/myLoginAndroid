package com.example.myapplication.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.myapplication.R;
import com.example.myapplication.data.model.AuthService;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.Token;
import com.example.myapplication.data.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private final ExecutorService executorService = Executors.newFixedThreadPool( 1 );
    AuthService authService;

    public LoginDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/localhost:8080") //localhost for emulator
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authService = retrofit.create(AuthService.class);
    }

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            executorService.execute( new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Response<Token> response =
                                authService.login( new User( "test@mail.com", "password" ) ).execute();
                        Token token = response.body();
                        //SharedPreferences.Editor sharedPref =
                        //        getSharedPreferences( getString( R.string.preference_file_key ), Context.MODE_PRIVATE ).edit();
                        //sharedPref.putString("TOKEN_KEY",token.getAccessToken());
                        LoggedInUser loggedInUser =  new LoggedInUser(user.getUsername(), getToken.body());
                        //return new Result.Success<>(loggedInUser);
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                }
            } );


        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
