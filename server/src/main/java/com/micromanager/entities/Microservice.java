package com.micromanager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Microservice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "groupId")
    private MicroserviceGroup group;

    public Microservice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MicroserviceGroup getGroup() {
        return group;
    }

    public void setGroup(MicroserviceGroup group) {
        this.group = group;
    }
}
