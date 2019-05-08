package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.User;
import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<User> findAll();
//    User save(User user);
    void deleteUser(int id);
}
