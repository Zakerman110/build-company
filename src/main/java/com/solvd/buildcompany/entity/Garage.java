package com.solvd.buildcompany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "garages")
public class Garage extends BaseEntity {

    @Column(length = 45, name = "address")
    private String address;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

    @JsonManagedReference
    @OneToMany(targetEntity=Vehicle.class)
    private List<Vehicle> vehicles;

    public Garage() {
    }

    public Garage(String address, Office office, List<Vehicle> vehicles) {
        this.address = address;
        this.office = office;
        this.vehicles = vehicles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Garage garage = (Garage) o;
        return Objects.equals(address, garage.address) && Objects.equals(office, garage.office) && Objects.equals(vehicles, garage.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, office, vehicles);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "address='" + address + '\'' +
                ", office=" + office +
                ", vehicles=" + vehicles +
                '}';
    }
}
