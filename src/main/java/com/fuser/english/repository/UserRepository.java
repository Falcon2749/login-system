package com.fuser.english.repository;

import com.fuser.english.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail (String email);

    @Query("SELECT e.gems FROM User e where e.id = ?1")
    int getUserGemsById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.enabled = true WHERE u.email = ?1")
    void enableUser(String email);
}
