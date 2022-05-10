package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "warehouses")
public class Warehouse extends BaseEntity {

    @Column(length = 45, name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

    @OneToMany
    private List<Material> materials;

    @OneToMany
    private List<Instrument> instruments;
}
