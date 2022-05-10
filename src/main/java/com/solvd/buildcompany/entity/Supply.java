package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity(name = "supplies")
public class Supply extends BaseEntity {

    @Column(name = "supply_date")
    private Date date;

    @OneToMany(targetEntity=SupplyDetail.class)
    private List<SupplyDetail> supplyDetails;
}
