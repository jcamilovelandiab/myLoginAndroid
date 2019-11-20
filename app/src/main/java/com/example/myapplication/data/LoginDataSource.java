package com.example.myapplication.data;

import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    Map<String, User> users = new HashMap<String, User>();

    public LoginDataSource(){
        User user = new User(java.util.UUID.randomUUID().toString(), "jcamilovb", "jcamilovb", "camilo");
        users.put(user.getUsername(), user);
    }

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            if(! users.containsKey(username)) throw new Exception("Invalid login!");
            User user = users.get(username);
            if(!user.getPassword().equals(password)) throw new Exception("Invalid login!");

            LoggedInUser loggedUser =
                    new LoggedInUser(user.getUserId(),
                            user.getUsername());
            return new Result.Success<>(loggedUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public Result<LoggedInUser> register(String username, String password, String fullname){
        try{
            User user = new User(java.util.UUID.randomUUID().toString(),
                                username, password, fullname);
            users.put(username, user);
            LoggedInUser loggedUser =
                    new LoggedInUser(user.getUserId(),
                            user.getUsername());
            return new Result.Success<>(loggedUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
