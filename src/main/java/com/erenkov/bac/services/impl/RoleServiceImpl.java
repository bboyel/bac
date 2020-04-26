package com.erenkov.bac.services.impl;

import com.erenkov.bac.entity.Role;
import com.erenkov.bac.repo.RoleRepo;
import com.erenkov.bac.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findByRoleName(String name) {
        Role findRole = roleRepo.findByRoleName(name);
        return findRole;
    }
}
