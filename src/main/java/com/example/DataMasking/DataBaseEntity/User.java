package com.example.DataMasking.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Users", indexes = {
        @Index(name = "UQ__Users__6845136ED458ADDF", columnList = "IdHistory", unique = true)
})
public class User {
    private Integer id;

    private String nameUser;

    private Departament idDepartament;

    private Integer idPosition;

    private String tabelNumber;

    private Integer idTelephon;

    private String loginUser;

    private String passwordsUser;

    private Boolean statusActual;

    private String idHistory;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NameUser", nullable = false, length = 256)
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDepartament")
    public Departament getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(Departament idDepartament) {
        this.idDepartament = idDepartament;
    }

    @Column(name = "IdPosition")
    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    @Column(name = "TabelNumber", length = 32)
    public String getTabelNumber() {
        return tabelNumber;
    }

    public void setTabelNumber(String tabelNumber) {
        this.tabelNumber = tabelNumber;
    }

    @Column(name = "IdTelephon")
    public Integer getIdTelephon() {
        return idTelephon;
    }

    public void setIdTelephon(Integer idTelephon) {
        this.idTelephon = idTelephon;
    }

    @Column(name = "LoginUser", length = 128)
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @Column(name = "PasswordsUser", length = 128)
    public String getPasswordsUser() {
        return passwordsUser;
    }

    public void setPasswordsUser(String passwordsUser) {
        this.passwordsUser = passwordsUser;
    }

    @Column(name = "StatusActual")
    public Boolean getStatusActual() {
        return statusActual;
    }

    public void setStatusActual(Boolean statusActual) {
        this.statusActual = statusActual;
    }

    @Column(name = "IdHistory", length = 64)
    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}