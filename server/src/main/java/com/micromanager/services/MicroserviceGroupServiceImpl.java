package com.micromanager.services;

import com.micromanager.entities.MicroserviceGroup;
import com.micromanager.models.MicroserviceGroupResponse;
import com.micromanager.repositories.MicroserviceGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MicroserviceGroupServiceImpl implements MicroserviceGroupService {
    @Autowired
    MicroserviceGroupRepository repo;

    @Override
    public Set<MicroserviceGroupResponse> getAllMicroserviceGroups() {
        Set<MicroserviceGroupResponse> retSet = new HashSet<>();
        for(MicroserviceGroup curMsGrp : repo.findAll()) {
            retSet.add(new MicroserviceGroupResponse(curMsGrp));
        }
        return retSet;
    }

    @Override
    public MicroserviceGroupResponse create(MicroserviceGroup group) {
        MicroserviceGroup savedGroup = repo.save(group);
        if(savedGroup != null) {
            return new MicroserviceGroupResponse(savedGroup);
        }
        return null;
    }
}
