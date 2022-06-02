package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(length = 45, name = "address")
    private String address;

    @Column(length = 45, name = "phone")
    private String phone;

    @Column(length = 45, name = "email")
    private String email;

    @OneToMany(targetEntity=Goods.class)
    private List<Goods> goods;

    public Supplier() {
    }

    public Supplier(String name, String address, String phone, String email, List<Goods> goods) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(name, supplier.name) && Objects.equals(address, supplier.address) && Objects.equals(phone, supplier.phone) && Objects.equals(email, supplier.email) && Objects.equals(goods, supplier.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address, phone, email, goods);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", goods=" + goods +
                '}';
    }
}
