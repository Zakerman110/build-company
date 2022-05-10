package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Instrument() {
    }

    public Instrument(float quantity, boolean isInUse, Warehouse warehouse, Goods goods, List<InstrumentUsage> instrumentUsages) {
        this.quantity = quantity;
        this.isInUse = isInUse;
        this.warehouse = warehouse;
        this.goods = goods;
        this.instrumentUsages = instrumentUsages;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<InstrumentUsage> getInstrumentUsages() {
        return instrumentUsages;
    }

    public void setInstrumentUsages(List<InstrumentUsage> instrumentUsages) {
        this.instrumentUsages = instrumentUsages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instrument that = (Instrument) o;
        return Float.compare(that.quantity, quantity) == 0 && isInUse == that.isInUse && Objects.equals(warehouse, that.warehouse) && Objects.equals(goods, that.goods) && Objects.equals(instrumentUsages, that.instrumentUsages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, isInUse, warehouse, goods, instrumentUsages);
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "quantity=" + quantity +
                ", isInUse=" + isInUse +
                ", warehouse=" + warehouse +
                ", goods=" + goods +
                ", instrumentUsages=" + instrumentUsages +
                '}';
    }
}
