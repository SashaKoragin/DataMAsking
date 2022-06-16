package com.example.DataMasking.ModelUserAndPassword;

import java.io.Serializable;

public class RuleDto implements Serializable {
    private final String nameRules;

    public RuleDto(String nameRules) {
        this.nameRules = nameRules;
    }

    public String getNameRules() {
        return nameRules;
    }
}
