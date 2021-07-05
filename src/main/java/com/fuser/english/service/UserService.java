package com.fuser.english.service;

import com.fuser.english.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> getByEmail(String email);
    void addUser(User user);
    List<User> getAll();
    int getUserGems(int id);
    Optional<User> getUserInfo(int id);
    String signUpUser(User user);
    void enableUser(String email);
}
