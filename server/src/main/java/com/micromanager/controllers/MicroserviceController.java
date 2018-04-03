package com.micromanager.controllers;

import com.micromanager.entities.Microservice;
import com.micromanager.entities.MicroserviceGroup;
import com.micromanager.models.MicroserviceInfo;
import com.micromanager.models.MicroserviceRequest;
import com.micromanager.models.MicroserviceResponse;
import com.micromanager.services.MicroserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MicroserviceController {

    @Autowired
    public MicroserviceService microserviceService;

    @GetMapping(path = "/api/microservices")
    public ResponseEntity<?> getMicroservices() {
        Set<MicroserviceInfo> retSet = microserviceService.getAllMicroservices();
        return new ResponseEntity<>(retSet, HttpStatus.OK);
    }

    @PostMapping(path = "/api/microservices")
    public ResponseEntity<?> createMicroservice(@RequestBody MicroserviceRequest service) {
        Microservice newService = new Microservice();
        newService.setName(service.getName());
        newService.setDescription(service.getDescription());
        MicroserviceGroup grp = new MicroserviceGroup();
        grp.setId(service.getGroupId());
        newService.setGroup(grp);

        MicroserviceResponse response = microserviceService.add(newService);
        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
