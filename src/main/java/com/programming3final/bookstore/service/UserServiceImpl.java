package com.programming3final.bookstore.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.programming3final.bookstore.dao.UserRepository;
import com.programming3final.bookstore.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // dependency injection
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public User findByUsername(String username) {
        User theUser = userRepository.findByUsername(username);
        return theUser;
    }

}
