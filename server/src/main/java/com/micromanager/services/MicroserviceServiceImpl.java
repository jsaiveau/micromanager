package com.micromanager.services;

import com.micromanager.entities.Microservice;
import com.micromanager.models.MicroserviceInfo;
import com.micromanager.models.MicroserviceResponse;
import com.micromanager.repositories.MicroserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MicroserviceServiceImpl implements MicroserviceService {
    @Autowired
    MicroserviceRepository repo;

    @Override
    public Set<MicroserviceInfo> getAllMicroservices() {
        Set<MicroserviceInfo> retSet = new HashSet<>();
        for(Microservice curMs : repo.findAll()) {
            retSet.add(new MicroserviceInfo(curMs));
        }
        return retSet;
    }

    @Override
    public MicroserviceResponse add(Microservice service) {
        Microservice savedService = repo.save(service);
        if(savedService != null) {
            return new MicroserviceResponse(savedService);
        }
        return null;
    }
}
