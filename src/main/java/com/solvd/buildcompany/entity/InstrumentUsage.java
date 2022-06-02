package com.solvd.buildcompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity(name = "instrumentUsage")
public class InstrumentUsage extends BaseEntity {

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "instruments_id", referencedColumnName = "id")
    private Instrument instrument;

    @ManyToOne
    @JoinColumn(name = "tasks_id", referencedColumnName = "id")
    private Task task;

    public InstrumentUsage() {
    }

    public InstrumentUsage(float quantity, Date date, Instrument instrument, Task task) {
        this.quantity = quantity;
        this.date = date;
        this.instrument = instrument;
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

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
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
        InstrumentUsage that = (InstrumentUsage) o;
        return Float.compare(that.quantity, quantity) == 0 && Objects.equals(date, that.date) && Objects.equals(instrument, that.instrument) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, date, instrument, task);
    }

    @Override
    public String toString() {
        return "InstrumentUsage{" +
                "quantity=" + quantity +
                ", date=" + date +
                ", instrument=" + instrument +
                ", task=" + task +
                '}';
    }
}
