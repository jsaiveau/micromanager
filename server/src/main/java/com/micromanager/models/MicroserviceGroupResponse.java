package com.micromanager.models;

import com.micromanager.entities.MicroserviceGroup;

public class MicroserviceGroupResponse {
    private Long id;
    private String name;
    private String description;

    public MicroserviceGroupResponse(MicroserviceGroup group) {
        this.id = group.getId();
        this.name = group.getName();
        this.description = group.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
