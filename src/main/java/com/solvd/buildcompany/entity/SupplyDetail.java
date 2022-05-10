package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "supplyDetails")
public class SupplyDetail extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @ManyToOne
    @JoinColumn(name = "supplies_id", referencedColumnName = "id")
    private Supply supply;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;
}
