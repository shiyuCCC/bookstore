package com.programming3final.bookstore.service;

import com.programming3final.bookstore.entity.User;

public interface UserService {

    void save(User theUser);

    User findByUsername(String username);
}
