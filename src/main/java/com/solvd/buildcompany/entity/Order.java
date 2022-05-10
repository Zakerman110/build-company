package com.solvd.buildcompany.entity;

import com.solvd.buildcompany.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
}
