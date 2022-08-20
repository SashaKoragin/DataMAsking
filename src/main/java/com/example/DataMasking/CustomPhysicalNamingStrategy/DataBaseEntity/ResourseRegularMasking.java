package com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class ResourseRegularMasking {
    private Integer id;

    private Instant dataCreate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRegularMasking", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "DataCreate")
    public Instant getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Instant dataCreate) {
        this.dataCreate = dataCreate;
    }

}