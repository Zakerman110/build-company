package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "materials")
public class Material extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @ManyToOne
    @JoinColumn(name = "warehouses_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    @OneToMany
    private List<MaterialUsage> materialUsages;
}
