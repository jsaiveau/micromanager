package com.micromanager.models;

import com.micromanager.entities.Microservice;

public class MicroserviceInfo {
    private String name;

    public MicroserviceInfo(Microservice curMs) {
        this.id = curMs.getId();
        this.name = curMs.getName();
        if(curMs.getGroup() != null) {
            this.group = curMs.getGroup().getName();
        }else
            this.group = "Default Group";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String group;
    private Long id;
}
