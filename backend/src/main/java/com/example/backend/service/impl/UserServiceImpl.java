package com.example.backend.service.impl;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){ this.repository = repository; }

    @Override
    public Iterable<User> findAll(){ return repository.findAll(); };

    @Override
    public User findByLogin(String login){ return repository.findByLogin(login); };

    @Override
    public User findByName(String name){ return repository.findByName(name); };

    @Override
    public User findByRoleId(int id){ return repository.findByRoleId(id); };

    @Override
    public User save(User user) {
        return repository.save(user);
    };

    @Override
    public void delete(int id){ repository.deleteById(id); };
}
