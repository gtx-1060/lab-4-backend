package com.stpdiron.lab4.repositories;

import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RolesRepository extends JpaRepository<Role, Long> {
    Set<Role> findRolesByName(String name);
}
