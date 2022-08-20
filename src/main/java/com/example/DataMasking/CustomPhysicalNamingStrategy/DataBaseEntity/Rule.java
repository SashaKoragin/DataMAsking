package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Rules")
public class Rule {
    private Integer id;

    private String infoRule;

    private String nameRules;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRule", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "InfoRule", length = 512)
    public String getInfoRule() {
        return infoRule;
    }

    public void setInfoRule(String infoRule) {
        this.infoRule = infoRule;
    }

    @Column(name = "NameRules", length = 128)
    public String getNameRules() {
        return nameRules;
    }

    public void setNameRules(String nameRules) {
        this.nameRules = nameRules;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}