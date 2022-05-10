package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(length = 45, name = "address")
    private String address;

    @Column(length = 45, name = "phone")
    private String phone;

    @Column(length = 45, name = "email")
    private String email;

    @OneToMany(targetEntity=Goods.class)
    private List<Goods> goods;
}
