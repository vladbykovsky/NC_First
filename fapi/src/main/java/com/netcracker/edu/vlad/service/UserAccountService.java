package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.User;
import java.util.List;

public interface UserAccountService {
    User findByLogin(String login);
    List<User> findAll();
    User saveUser(User user);
}
