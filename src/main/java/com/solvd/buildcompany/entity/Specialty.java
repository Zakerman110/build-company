package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "specialties")
public class Specialty extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @ManyToMany(mappedBy = "employeeSpecialties")
    private List<Employee> specialtyEmployees;

    public Specialty() {
    }

    public Specialty(String name, List<Employee> specialtyEmployees) {
        this.name = name;
        this.specialtyEmployees = specialtyEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getSpecialtyEmployees() {
        return specialtyEmployees;
    }

    public void setSpecialtyEmployees(List<Employee> specialtyEmployees) {
        this.specialtyEmployees = specialtyEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(name, specialty.name) && Objects.equals(specialtyEmployees, specialty.specialtyEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, specialtyEmployees);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "name='" + name + '\'' +
                ", specialtyEmployees=" + specialtyEmployees +
                '}';
    }
}
