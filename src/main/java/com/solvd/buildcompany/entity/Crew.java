package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "crews")
public class Crew extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(length = 45, name = "description")
    private String description;

    @ManyToMany(mappedBy = "employeeCrews")
    private List<Employee> crewEmployees;
}
