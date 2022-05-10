package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "specialties")
public class Specialty extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @ManyToMany(mappedBy = "employeeSpecialties")
    private List<Employee> specialtyEmployees;
}
