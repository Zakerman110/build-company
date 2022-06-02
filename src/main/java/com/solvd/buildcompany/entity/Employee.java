package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

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

    public Employee() {
    }

    public Employee(String firstName,
                    String lastName,
                    String phone,
                    String email,
                    String address,
                    Date birthDate,
                    Date hireDate,
                    Office office,
                    List<Specialty> employeeSpecialties,
                    List<Crew> employeeCrews) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.office = office;
        this.employeeSpecialties = employeeSpecialties;
        this.employeeCrews = employeeCrews;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Specialty> getEmployeeSpecialties() {
        return employeeSpecialties;
    }

    public void setEmployeeSpecialties(List<Specialty> employeeSpecialties) {
        this.employeeSpecialties = employeeSpecialties;
    }

    public List<Crew> getEmployeeCrews() {
        return employeeCrews;
    }

    public void setEmployeeCrews(List<Crew> employeeCrews) {
        this.employeeCrews = employeeCrews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
                Objects.equals(phone, employee.phone) && Objects.equals(email, employee.email) &&
                Objects.equals(address, employee.address) && Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(hireDate, employee.hireDate) && Objects.equals(office, employee.office) &&
                Objects.equals(employeeSpecialties, employee.employeeSpecialties) &&
                Objects.equals(employeeCrews, employee.employeeCrews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phone, email, address, birthDate,
                hireDate, office, employeeSpecialties, employeeCrews);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", office=" + office +
                ", employeeSpecialties=" + employeeSpecialties +
                ", employeeCrews=" + employeeCrews +
                '}';
    }
}
