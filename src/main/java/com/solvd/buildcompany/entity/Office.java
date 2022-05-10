package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    public Office() {
    }

    public Office(String city,
                  String address,
                  String phone,
                  String email,
                  List<Order> orders,
                  List<Employee> employees,
                  List<Garage> garages,
                  List<Warehouse> warehouses) {
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.orders = orders;
        this.employees = employees;
        this.garages = garages;
        this.warehouses = warehouses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Office office = (Office) o;
        return Objects.equals(city, office.city) && Objects.equals(address, office.address) &&
                Objects.equals(phone, office.phone) && Objects.equals(email, office.email) &&
                Objects.equals(orders, office.orders) && Objects.equals(employees, office.employees) &&
                Objects.equals(garages, office.garages) && Objects.equals(warehouses, office.warehouses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, address, phone, email, orders, employees, garages, warehouses);
    }

    @Override
    public String toString() {
        return "Office{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                ", employees=" + employees +
                ", garages=" + garages +
                ", warehouses=" + warehouses +
                '}';
    }
}
