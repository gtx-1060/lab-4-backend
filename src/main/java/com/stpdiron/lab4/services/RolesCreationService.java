package com.stpdiron.lab4.services;

import com.stpdiron.lab4.entities.Role;
import com.stpdiron.lab4.repositories.RolesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RolesCreationService {
    @Value("${roles}")
    private String roles;
    private final RolesRepository repository;

    @Autowired
    public RolesCreationService(RolesRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        for (String role : roles.split(", ")) {
            if (repository.findRolesByName(role).isEmpty()) {
                repository.save(new Role(role));
            }
        }
    }
}
