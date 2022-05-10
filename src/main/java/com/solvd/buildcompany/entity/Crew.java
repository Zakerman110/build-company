package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "crews")
public class Crew extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(length = 45, name = "description")
    private String description;

    @ManyToMany(mappedBy = "employeeCrews")
    private List<Employee> crewEmployees;

    public Crew() {
    }

    public Crew(String name, String description, List<Employee> crewEmployees) {
        this.name = name;
        this.description = description;
        this.crewEmployees = crewEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getCrewEmployees() {
        return crewEmployees;
    }

    public void setCrewEmployees(List<Employee> crewEmployees) {
        this.crewEmployees = crewEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Crew crew = (Crew) o;
        return Objects.equals(name, crew.name) && Objects.equals(description, crew.description) && Objects.equals(crewEmployees, crew.crewEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, crewEmployees);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", crewEmployees=" + crewEmployees +
                '}';
    }
}
