package com.erenkov.bac.repo;

import com.erenkov.bac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Реализацию предоставит Spring
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRoleName(String name);
}