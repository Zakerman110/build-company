package com.solvd.buildcompany.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@JsonAutoDetect
@Entity(name = "vehicles")
public class Vehicle extends BaseEntity {

    @Column(length = 45, name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(length = 45, name = "license_plate")
    private String licensePlate;

    @Column(length = 45, name = "color")
    private String color;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "garages_id", referencedColumnName = "id")
    private Garage garage;

    public Vehicle() {
    }

    public Vehicle(String model, int year, String licensePlate, String color, Garage garage) {
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.color = color;
        this.garage = garage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(model, vehicle.model) && Objects.equals(licensePlate, vehicle.licensePlate) && Objects.equals(color, vehicle.color) && Objects.equals(garage, vehicle.garage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, year, licensePlate, color, garage);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                ", color='" + color + '\'' +
                ", garage=" + garage +
                '}';
    }
}
