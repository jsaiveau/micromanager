package com.micromanager.services;

import com.micromanager.entities.MicroserviceGroup;
import com.micromanager.models.MicroserviceGroupResponse;

import java.util.Set;

public interface MicroserviceGroupService {
    public Set<MicroserviceGroupResponse> getAllMicroserviceGroups();

    public MicroserviceGroupResponse create(MicroserviceGroup group);
}
