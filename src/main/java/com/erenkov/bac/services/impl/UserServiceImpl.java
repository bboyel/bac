package com.erenkov.bac.services.impl;

import com.erenkov.bac.entity.Role;
import com.erenkov.bac.entity.User;
import com.erenkov.bac.repo.UserRepo;
import com.erenkov.bac.services.RoleService;
import com.erenkov.bac.services.UserService;
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
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveAndFlush(User user) {

        //перезаписываем пароль в зашифрованном виде
        user.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));  // Получаем роль User из БД
        user.setRoles(new HashSet<>(roles));                 // Устанавливам роль пользователю

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}