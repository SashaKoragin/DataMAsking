package com.example.DataMasking.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class InfoColumn {
    private Integer id;

    private InfoTable idInfoTable;

    private ResourseRegularMasking idRegularMasking;

    private String nameColumn;

    private String tupeColumn;

    private String infoColumn;

    private Boolean isMasking;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInfoColumn", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRegularMasking")
    public ResourseRegularMasking getIdRegularMasking() {
        return idRegularMasking;
    }

    public void setIdRegularMasking(ResourseRegularMasking idRegularMasking) {
        this.idRegularMasking = idRegularMasking;
    }

    @Column(name = "NameColumn", length = 128)
    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    @Column(name = "TupeColumn", length = 128)
    public String getTupeColumn() {
        return tupeColumn;
    }

    public void setTupeColumn(String tupeColumn) {
        this.tupeColumn = tupeColumn;
    }

    @Column(name = "InfoColumn", length = 1024)
    public String getInfoColumn() {
        return infoColumn;
    }

    public void setInfoColumn(String infoColumn) {
        this.infoColumn = infoColumn;
    }

    @Column(name = "IsMasking")
    public Boolean getIsMasking() {
        return isMasking;
    }

    public void setIsMasking(Boolean isMasking) {
        this.isMasking = isMasking;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}