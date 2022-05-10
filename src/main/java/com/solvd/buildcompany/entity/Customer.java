package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

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
}
