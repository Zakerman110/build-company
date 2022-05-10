package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "materialsUsage")
public class MaterialUsage extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "materials_id", referencedColumnName = "id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "tasks_id", referencedColumnName = "id")
    private Task task;
}
