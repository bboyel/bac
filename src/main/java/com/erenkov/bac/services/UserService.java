package com.erenkov.bac.services;

import com.erenkov.bac.entity.User;

public interface UserService {

    User findByUsername(String username);

    User saveAndFlush(User user);

}