package com.micromanager.controllers;

import com.micromanager.entities.MicroserviceGroup;
import com.micromanager.models.MicroserviceGroupResponse;
import com.micromanager.services.MicroserviceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MicroserviceGroupController {

    @Autowired
    public MicroserviceGroupService msGrpService;

    @GetMapping(path = "/api/microservice-groups")
    public ResponseEntity<?> getMicroserviceGroups() {
        Set<MicroserviceGroupResponse> retSet = msGrpService.getAllMicroserviceGroups();
        return new ResponseEntity<>(retSet, HttpStatus.OK);
    }

    @PostMapping(path = "/api/microservice-groups")
    public ResponseEntity<?> createMicroserviceGroup(@RequestBody MicroserviceGroup group) {
        MicroserviceGroupResponse response = msGrpService.create(group);
        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
