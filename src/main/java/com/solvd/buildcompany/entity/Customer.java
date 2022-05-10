package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity(name = "customers")
public class Customer extends BaseEntity {

    @Column(length = 45, name = "first_name")
    private String firstName;

    @Column(length = 45, name = "last_name")
    private String lastName;

    @Column(length = 45, name = "phone")
    private String phone;

    @Column(name = "createdAt")
    private Date createdAt;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone, Date createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) &&
                Objects.equals(phone, customer.phone) && Objects.equals(createdAt, customer.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phone, createdAt);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
