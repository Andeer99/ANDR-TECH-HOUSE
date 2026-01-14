package com.andrtechhouse.repository;

import com.andrtechhouse.model.Role;
import com.andrtechhouse.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
