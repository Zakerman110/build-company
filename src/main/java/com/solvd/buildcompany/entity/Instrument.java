package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "instruments")
public class Instrument extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "is_in_use")
    private boolean isInUse;

    @ManyToOne
    @JoinColumn(name = "warehouses_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    @OneToMany
    private List<InstrumentUsage> instrumentUsages;
}
