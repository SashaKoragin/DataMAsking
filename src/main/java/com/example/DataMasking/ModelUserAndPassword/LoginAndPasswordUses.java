package com.example.DataMasking.ModelUserAndPassword;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginAndPasswordUses {
    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public LoginAndPasswordUses(String login, String password) {
        Login = login;
        Password = password;
    }

    private String Login;
    private String Password;


}
