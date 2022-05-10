package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "offices")
public class Office extends BaseEntity {

    @Column(length = 45, name = "city")
    private String city;

    @Column(length = 45, name = "address")
    private String address;

    @Column(length = 45, name = "phone")
    private String phone;

    @Column(length = 45, name = "email")
    private String email;

    @OneToMany(targetEntity=Order.class)
    private List<Order> orders;

    @OneToMany(targetEntity=Employee.class)
    private List<Employee> employees;

    @OneToMany(targetEntity=Garage.class)
    private List<Garage> garages;

    @OneToMany(targetEntity=Warehouse.class)
    private List<Warehouse> warehouses;

}
