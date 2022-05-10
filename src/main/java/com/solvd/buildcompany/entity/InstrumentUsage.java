package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "instrumentUsage")
public class InstrumentUsage extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "instruments_id", referencedColumnName = "id")
    private Instrument instrument;

    @ManyToOne
    @JoinColumn(name = "tasks_id", referencedColumnName = "id")
    private Task task;
}
