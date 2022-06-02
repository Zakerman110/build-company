package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "supplies")
public class Supply extends BaseEntity {

    @Column(name = "supply_date")
    private Date date;

    @OneToMany(targetEntity=SupplyDetail.class)
    private List<SupplyDetail> supplyDetails;

    public Supply() {
    }

    public Supply(Date date, List<SupplyDetail> supplyDetails) {
        this.date = date;
        this.supplyDetails = supplyDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SupplyDetail> getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(List<SupplyDetail> supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Supply supply = (Supply) o;
        return Objects.equals(date, supply.date) && Objects.equals(supplyDetails, supply.supplyDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, supplyDetails);
    }

    @Override
    public String toString() {
        return "Supply{" +
                "date=" + date +
                ", supplyDetails=" + supplyDetails +
                '}';
    }
}
