package com.micromanager.repositories;

import com.micromanager.entities.MicroserviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroserviceGroupRepository extends JpaRepository<MicroserviceGroup, Long> {
}
