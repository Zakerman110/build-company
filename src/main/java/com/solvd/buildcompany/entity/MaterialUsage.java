package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity(name = "materialsUsage")
public class MaterialUsage extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "materials_id", referencedColumnName = "id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "tasks_id", referencedColumnName = "id")
    private Task task;

    public MaterialUsage() {
    }

    public MaterialUsage(float quantity, Date date, Material material, Task task) {
        this.quantity = quantity;
        this.date = date;
        this.material = material;
        this.task = task;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaterialUsage that = (MaterialUsage) o;
        return Float.compare(that.quantity, quantity) == 0 && Objects.equals(date, that.date) && Objects.equals(material, that.material) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, date, material, task);
    }

    @Override
    public String toString() {
        return "MaterialUsage{" +
                "quantity=" + quantity +
                ", date=" + date +
                ", material=" + material +
                ", task=" + task +
                '}';
    }
}
