package com.solvd.buildcompany.entity;

import com.solvd.buildcompany.enums.GoodsType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "goods")
public class Goods extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private GoodsType type;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "suppliers_id", referencedColumnName = "id")
    private Supplier supplier;

    @OneToMany(targetEntity=SupplyDetail.class)
    private List<SupplyDetail> supplyDetails;

    @OneToMany(targetEntity=Material.class)
    private List<Material> materials;

    @OneToMany(targetEntity=Instrument.class)
    private List<Instrument> instruments;
}
