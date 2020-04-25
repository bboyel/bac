package com.erenkov.bac.services;

import com.erenkov.bac.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}