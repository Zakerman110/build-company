package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Material() {
    }

    public Material(float quantity, Warehouse warehouse, Goods goods, List<MaterialUsage> materialUsages) {
        this.quantity = quantity;
        this.warehouse = warehouse;
        this.goods = goods;
        this.materialUsages = materialUsages;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
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

    public List<MaterialUsage> getMaterialUsages() {
        return materialUsages;
    }

    public void setMaterialUsages(List<MaterialUsage> materialUsages) {
        this.materialUsages = materialUsages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Material material = (Material) o;
        return Float.compare(material.quantity, quantity) == 0 && Objects.equals(warehouse, material.warehouse) && Objects.equals(goods, material.goods) && Objects.equals(materialUsages, material.materialUsages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, warehouse, goods, materialUsages);
    }

    @Override
    public String toString() {
        return "Material{" +
                "quantity=" + quantity +
                ", warehouse=" + warehouse +
                ", goods=" + goods +
                ", materialUsages=" + materialUsages +
                '}';
    }
}
