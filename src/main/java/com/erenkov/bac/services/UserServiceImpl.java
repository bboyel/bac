package com.erenkov.bac.services;

import com.erenkov.bac.entity.Role;
import com.erenkov.bac.entity.User;
import com.erenkov.bac.repo.UserRepo;
import com.erenkov.bac.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}