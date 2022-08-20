package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class InfoTable {
    private Integer id;

    private ConnectionString idConnectionString;

    private String nameTable;

    private String infoTable;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInfoTable", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdConnectionString")
    public ConnectionString getIdConnectionString() {
        return idConnectionString;
    }

    public void setIdConnectionString(ConnectionString idConnectionString) {
        this.idConnectionString = idConnectionString;
    }

    @Column(name = "NameTable", length = 128)
    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    @Column(name = "InfoTable", length = 1024)
    public String getInfoTable() {
        return infoTable;
    }

    public void setInfoTable(String infoTable) {
        this.infoTable = infoTable;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}