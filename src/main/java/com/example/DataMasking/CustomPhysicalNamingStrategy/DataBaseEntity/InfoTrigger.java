package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class InfoTrigger {
    private Integer id;

    private InfoTable idInfoTable;

    private String nameTrigger;

    private String infoTrigger;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInfoTrigger", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdInfoTable")
    public InfoTable getIdInfoTable() {
        return idInfoTable;
    }

    public void setIdInfoTable(InfoTable idInfoTable) {
        this.idInfoTable = idInfoTable;
    }

    @Column(name = "NameTrigger", length = 128)
    public String getNameTrigger() {
        return nameTrigger;
    }

    public void setNameTrigger(String nameTrigger) {
        this.nameTrigger = nameTrigger;
    }

    @Column(name = "InfoTrigger", length = 1024)
    public String getInfoTrigger() {
        return infoTrigger;
    }

    public void setInfoTrigger(String infoTrigger) {
        this.infoTrigger = infoTrigger;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}