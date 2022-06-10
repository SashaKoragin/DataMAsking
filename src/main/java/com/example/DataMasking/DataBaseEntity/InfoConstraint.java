package com.example.DataMasking.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class InfoConstraint {
    private Integer id;

    private InfoTable idInfoTable;

    private String nameConstraint;

    private String infoConstraint;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInfoConstraint", nullable = false)
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

    @Column(name = "NameConstraint", length = 128)
    public String getNameConstraint() {
        return nameConstraint;
    }

    public void setNameConstraint(String nameConstraint) {
        this.nameConstraint = nameConstraint;
    }

    @Column(name = "InfoConstraint", length = 1024)
    public String getInfoConstraint() {
        return infoConstraint;
    }

    public void setInfoConstraint(String infoConstraint) {
        this.infoConstraint = infoConstraint;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}