package com.solvd.buildcompany.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
}
