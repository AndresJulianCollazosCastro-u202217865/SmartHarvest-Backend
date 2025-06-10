package com.example.demo.security.repositories;

import com.example.demo.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
