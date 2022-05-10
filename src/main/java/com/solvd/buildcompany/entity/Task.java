package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "tasks")
public class Task extends BaseEntity {

    @Column(length = 45, name = "name")
    private String name;

    @Column(length = 200, name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "crews_id", referencedColumnName = "id")
    private Crew crew;

    @OneToMany
    private List<MaterialUsage> materialUsages;

    @OneToMany
    private List<InstrumentUsage> instrumentUsages;

    public Task() {
    }

    public Task(String name,
                String description,
                Date startDate,
                Date endDate,
                Order order,
                Crew crew,
                List<MaterialUsage> materialUsages,
                List<InstrumentUsage> instrumentUsages) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.order = order;
        this.crew = crew;
        this.materialUsages = materialUsages;
        this.instrumentUsages = instrumentUsages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public List<MaterialUsage> getMaterialUsages() {
        return materialUsages;
    }

    public void setMaterialUsages(List<MaterialUsage> materialUsages) {
        this.materialUsages = materialUsages;
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
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(startDate, task.startDate) && Objects.equals(endDate, task.endDate) && Objects.equals(order, task.order) && Objects.equals(crew, task.crew) && Objects.equals(materialUsages, task.materialUsages) && Objects.equals(instrumentUsages, task.instrumentUsages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, startDate, endDate, order, crew, materialUsages, instrumentUsages);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", order=" + order +
                ", crew=" + crew +
                ", materialUsages=" + materialUsages +
                ", instrumentUsages=" + instrumentUsages +
                '}';
    }
}
