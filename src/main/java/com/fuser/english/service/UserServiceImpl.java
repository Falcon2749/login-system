package com.fuser.english.service;

import com.fuser.english.entity.User;
import com.fuser.english.service.registration.token.ConfirmationToken;
import com.fuser.english.service.registration.token.ConfirmationTokenService;
import com.fuser.english.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;


    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll()) ;
    }

    @Override
    public int getUserGems(int id) {
        int output;
        try {
            output = userRepository.getUserGemsById(id);
        } catch (AopInvocationException e){
            System.out.println("No user found");
            output = -1;
        }
        return output;
    }

    @Override
    public Optional<User> getUserInfo(int id) {
        return userRepository.findById(id);
    }

    @Override
    public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail())
                .isPresent();
        if (userExists){
//            TODO: if user exists but token expired, send token again
            throw new IllegalStateException("Email is already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL
        return token;

    }

    @Override
    public void enableUser(String email) {
        userRepository.enableUser(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("user with email %s not found", email)));
    }


}
