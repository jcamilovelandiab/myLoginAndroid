package com.example.myapplication.data;

import com.example.myapplication.data.model.AuthService;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.Token;
import com.example.myapplication.data.model.User;
import com.example.myapplication.ui.login.LoginViewModel;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private AuthService authService;

    private final ExecutorService executorService = Executors.newFixedThreadPool( 1 );

    // private constructor : singleton access
    private LoginRepository() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/192.168.1.143:8080") //localhost for emulator
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authService = retrofit.create(AuthService.class);
    }

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public void login(final LoginViewModel loginViewModel, final String email, final String password) {
        executorService.execute( new Runnable(){
            @Override
            public void run()
            {
                try{
                    Response<Token> response =
                            authService.login( new User( email, password ) ).execute();
                    Token token = response.body();
                    if(token == null){
                        loginViewModel.requestLoginCompleted(false,null);
                    }else{

                        loginViewModel.requestLoginCompleted(true, new LoggedInUser(email, token));
                    }

                }
                catch ( IOException e ){
                    e.printStackTrace();
                    loginViewModel.requestLoginCompleted(false,null);
                }
            }
        } );
        /*Token token = null;
        if(email.equals("test@mail.com") && password.equals("test123")){
            token = new Token("this is my token");
        }
        if(token == null){
            loginViewModel.requestLoginCompleted(false,null);
        }else{
            loginViewModel.requestLoginCompleted(true, new LoggedInUser(email, token));
        }*/
    }

}
