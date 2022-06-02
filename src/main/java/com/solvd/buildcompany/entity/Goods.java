package com.solvd.buildcompany.entity;

import com.solvd.buildcompany.enums.GoodsType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    public Goods() {
    }

    public Goods(String name, GoodsType type, BigDecimal price, Supplier supplier, List<SupplyDetail> supplyDetails,
                 List<Material> materials, List<Instrument> instruments) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.supplier = supplier;
        this.supplyDetails = supplyDetails;
        this.materials = materials;
        this.instruments = instruments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<SupplyDetail> getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(List<SupplyDetail> supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(name, goods.name) && type == goods.type && Objects.equals(price, goods.price) && Objects.equals(supplier, goods.supplier) && Objects.equals(supplyDetails, goods.supplyDetails) && Objects.equals(materials, goods.materials) && Objects.equals(instruments, goods.instruments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, type, price, supplier, supplyDetails, materials, instruments);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", supplier=" + supplier +
                ", supplyDetails=" + supplyDetails +
                ", materials=" + materials +
                ", instruments=" + instruments +
                '}';
    }
}
