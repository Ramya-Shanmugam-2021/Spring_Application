package com.ecommerce.EcomApp.repositories;

import com.ecommerce.EcomApp.model.AppRole;
import com.ecommerce.EcomApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
