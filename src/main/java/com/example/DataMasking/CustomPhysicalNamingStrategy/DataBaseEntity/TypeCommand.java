package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class TypeCommand {
    private Integer id;

    private String infoType;

    private String nameTupeCommand;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTupeCommand", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "InfoType", nullable = false, length = 512)
    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    @Column(name = "NameTupeCommand", nullable = false, length = 128)
    public String getNameTupeCommand() {
        return nameTupeCommand;
    }

    public void setNameTupeCommand(String nameTupeCommand) {
        this.nameTupeCommand = nameTupeCommand;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}