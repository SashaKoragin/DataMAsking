package com.example.DataMasking.ModelUserAndPassword;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class UserDtoLoginAndPassword implements Serializable {
    private final String nameUser;
    private final String tabelNumber;
    private final String loginUser;
    private final String passwordsUser;
    private final Boolean isError;
    private final Boolean errorMessage;
    private final String[] groupRuleServer;

    public UserDtoLoginAndPassword(String nameUser, String tabelNumber, String loginUser, String passwordsUser, Boolean isError,Boolean errorMessage,  String[] groupRuleServer) {
        this.nameUser = nameUser;
        this.tabelNumber = tabelNumber;
        this.loginUser = loginUser;
        this.passwordsUser = passwordsUser;
        this.errorMessage = errorMessage;
        this.groupRuleServer = groupRuleServer;
        this.isError = isError;

    }


    public Boolean getErrorMessage() {
        return errorMessage;
    }

    public String[] getGroupRuleServer() {
        return groupRuleServer;
    }

    public Boolean getError() {
        return isError;
    }

    public String getPasswordsUser() {
        return passwordsUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getTabelNumber() {
        return tabelNumber;
    }

    public String getNameUser() {
        return nameUser;
    }
}
