package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "garages")
public class Garage extends BaseEntity {

    @Column(length = 45, name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

    @OneToMany(targetEntity=Vehicle.class)
    private List<Vehicle> vehicles;
}
