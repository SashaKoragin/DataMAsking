package com.example.DataMasking.ModelUserAndPassword;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class UserDtoLoginAndPassword implements Serializable {
    private final String nameUser;
    private final String tabelNumber;
    private final String loginUser;
    private final String passwordsUser;
    private final Boolean statusActual;
    private final Set<List<RuleDto>> ruleUsers;

    public UserDtoLoginAndPassword(String nameUser, String tabelNumber, String loginUser, String passwordsUser, Boolean statusActual, Set<List<RuleDto>> ruleUsers) {
        this.nameUser = nameUser;
        this.tabelNumber = tabelNumber;
        this.loginUser = loginUser;
        this.passwordsUser = passwordsUser;
        this.statusActual = statusActual;
        this.ruleUsers = ruleUsers;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getTabelNumber() {
        return tabelNumber;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPasswordsUser() {
        return passwordsUser;
    }

    public Boolean getStatusActual() {
        return statusActual;
    }

    public Set<List<RuleDto>> getRuleAndUsers() {
        return ruleUsers;
    }
}
