package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class CommandSql {
    private Integer id;

    private TupeDataBase idTupeDataBase;

    private TypeCommand idTupeCommand;

    private ResultCommand idResultCommand;

    private String commandSql;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCommand", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTupeDataBase")
    public TupeDataBase getIdTupeDataBase() {
        return idTupeDataBase;
    }

    public void setIdTupeDataBase(TupeDataBase idTupeDataBase) {
        this.idTupeDataBase = idTupeDataBase;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTupeCommand")
    public TypeCommand getIdTupeCommand() {
        return idTupeCommand;
    }

    public void setIdTupeCommand(TypeCommand idTupeCommand) {
        this.idTupeCommand = idTupeCommand;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdResultCommand")
    public ResultCommand getIdResultCommand() {
        return idResultCommand;
    }

    public void setIdResultCommand(ResultCommand idResultCommand) {
        this.idResultCommand = idResultCommand;
    }

    @Lob
    @Column(name = "CommandSql")
    public String getCommandSql() {
        return commandSql;
    }

    public void setCommandSql(String commandSql) {
        this.commandSql = commandSql;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}