package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "warehouses")
public class Warehouse extends BaseEntity {

    @Column(length = 45, name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "offices_id", referencedColumnName = "id")
    private Office office;

    @OneToMany
    private List<Material> materials;

    @OneToMany
    private List<Instrument> instruments;

    public Warehouse() {
    }

    public Warehouse(String address, Office office, List<Material> materials, List<Instrument> instruments) {
        this.address = address;
        this.office = office;
        this.materials = materials;
        this.instruments = instruments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(address, warehouse.address) && Objects.equals(office, warehouse.office) && Objects.equals(materials, warehouse.materials) && Objects.equals(instruments, warehouse.instruments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, office, materials, instruments);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "address='" + address + '\'' +
                ", office=" + office +
                ", materials=" + materials +
                ", instruments=" + instruments +
                '}';
    }
}
