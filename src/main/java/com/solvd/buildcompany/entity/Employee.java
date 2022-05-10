package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "employees")
public class Employee extends BaseEntity {

    @Column(length = 45, name = "first_name")
    private String firstName;

    @Column(length = 45, name = "last_name")
    private String lastName;

    @Column(length = 45, name = "phone")
    private String phone;

    @Column(length = 45, name = "email")
    private String email;

    @Column(length = 45, name = "address")
    private String address;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "hire_date")
    private Date hireDate;

    @ManyToMany
    @JoinTable(
        name = "employees_has_specialties",
        joinColumns = @JoinColumn(name = "employees_id"),
        inverseJoinColumns = @JoinColumn(name = "specialties_id"))
    private List<Specialty> employeeSpecialties;

    @ManyToMany
    @JoinTable(
            name = "crews_has_employees",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "crews_id"))
    private List<Crew> employeeCrews;
}
