package com.micromanager.repositories;

import com.micromanager.entities.Microservice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {
}
