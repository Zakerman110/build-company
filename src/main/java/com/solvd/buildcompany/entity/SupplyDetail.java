package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

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

    public SupplyDetail() {
    }

    public SupplyDetail(float quantity, Supply supply, Goods goods) {
        this.quantity = quantity;
        this.supply = supply;
        this.goods = goods;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SupplyDetail that = (SupplyDetail) o;
        return Float.compare(that.quantity, quantity) == 0 && Objects.equals(supply, that.supply) && Objects.equals(goods, that.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, supply, goods);
    }

    @Override
    public String toString() {
        return "SupplyDetail{" +
                "quantity=" + quantity +
                ", supply=" + supply +
                ", goods=" + goods +
                '}';
    }
}
