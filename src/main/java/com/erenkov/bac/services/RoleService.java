package com.erenkov.bac.services;
import com.erenkov.bac.entity.Role;

public interface RoleService {

    Role findByRoleName(String name);
}
