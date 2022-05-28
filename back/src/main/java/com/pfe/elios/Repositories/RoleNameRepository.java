package com.pfe.elios.Repositories;

import com.pfe.elios.entities.Role;
import com.pfe.elios.entities.RolesName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleNameRepository extends JpaRepository<RolesName, Long> {
    Optional<RolesName> findByName(Role name);
}
