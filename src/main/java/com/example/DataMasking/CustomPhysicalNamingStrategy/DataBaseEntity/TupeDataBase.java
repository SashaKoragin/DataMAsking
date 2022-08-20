package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class TupeDataBase {
    private Integer id;

    private String nameTypeDataBase;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTupeDataBase", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NameTypeDataBase", nullable = false, length = 128)
    public String getNameTypeDataBase() {
        return nameTypeDataBase;
    }

    public void setNameTypeDataBase(String nameTypeDataBase) {
        this.nameTypeDataBase = nameTypeDataBase;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}