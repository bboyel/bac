package com.erenkov.bac.repo;

import com.erenkov.bac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Реализацию предоставит Spring
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String name);

}