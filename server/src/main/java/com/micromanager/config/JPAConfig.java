package com.micromanager.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.micromanager.repositories")
@EntityScan("com.micromanager.entities")
public class JPAConfig {
}
