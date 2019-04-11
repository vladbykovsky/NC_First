package com.example.backend.service;

import com.example.backend.entity.User;


public interface UserService {

    Iterable<User> findAll();
    User findByLogin(String login);
    User save(User user);
    void delete(int id);

}
