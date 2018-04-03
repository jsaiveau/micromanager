package com.micromanager.services;

import com.micromanager.entities.Microservice;
import com.micromanager.models.MicroserviceInfo;
import com.micromanager.models.MicroserviceResponse;

import java.util.Set;

public interface MicroserviceService {
    public Set<MicroserviceInfo> getAllMicroservices();

    public MicroserviceResponse add(Microservice service);
}
