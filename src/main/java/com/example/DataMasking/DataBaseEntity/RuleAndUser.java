package com.example.DataMasking.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "RuleAndUsers")
public class RuleAndUser {
    private Integer id;

    private User idUser;

    private Rule idRule;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRuleAndUsers", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdUser", nullable = false)
    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdRule", nullable = false)
    public Rule getIdRule() {
        return idRule;
    }

    public void setIdRule(Rule idRule) {
        this.idRule = idRule;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}