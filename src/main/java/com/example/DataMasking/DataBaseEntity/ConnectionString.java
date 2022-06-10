package com.example.DataMasking.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class ConnectionString {
    private Integer id;

    private User idUser;

    private TupeDataBase idTupeDataBase;

    private String hostName;

    private String userName;

    private String password;

    private String nameDataBase;

    private Integer port;

    private String fullConnectionString;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdConnectionString", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUser")
    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTupeDataBase")
    public TupeDataBase getIdTupeDataBase() {
        return idTupeDataBase;
    }

    public void setIdTupeDataBase(TupeDataBase idTupeDataBase) {
        this.idTupeDataBase = idTupeDataBase;
    }

    @Column(name = "HostName", length = 128)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Column(name = "UserName", length = 128)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "Password", length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "NameDataBase", length = 128)
    public String getNameDataBase() {
        return nameDataBase;
    }

    public void setNameDataBase(String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    @Column(name = "Port")
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Column(name = "FullConnectionString", length = 1024)
    public String getFullConnectionString() {
        return fullConnectionString;
    }

    public void setFullConnectionString(String fullConnectionString) {
        this.fullConnectionString = fullConnectionString;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}