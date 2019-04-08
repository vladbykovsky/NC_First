package com.example.backend.service;

import com.example.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    User findByLogin(String login);
    User findByName(String name);
    User findByRoleId(int id);
    User save(User user);
    void delete(int id);

}
