package com.erenkov.bac;


import java.util.Date;
import java.util.List;

import com.erenkov.bac.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String name);

}