package com.solvd.buildcompany.entity;

import com.solvd.buildcompany.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name = "orders")
public class Order extends BaseEntity {

    @Column(length = 45, name = "address")
    private String address;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Customer customer;

    public Order() {
    }

    public Order(String address,
                 BigDecimal price,
                 Status status,
                 Date startDate,
                 Date endDate,
                 Office office,
                 Customer customer) {
        this.address = address;
        this.price = price;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.office = office;
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(address, order.address) && Objects.equals(price, order.price) && status == order.status && Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate) && Objects.equals(office, order.office) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, price, status, startDate, endDate, office, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", office=" + office +
                ", customer=" + customer +
                '}';
    }
}
