package com.erenkov.bac.repo;

import com.erenkov.bac.entity.Role;
import com.erenkov.bac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);

}