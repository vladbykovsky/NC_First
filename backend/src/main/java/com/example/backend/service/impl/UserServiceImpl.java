package com.example.backend.service.impl;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository){ this.userRepository = repository; }

    @Override
    public List<User> findAll(){ return (List<User>) userRepository.findAll(); };

    @Override
    public User findByLogin(String login){ return userRepository.findByLogin(login); };

    @Override
    public User save(User user) {
        return userRepository.save(user);
    };

    @Override
    public void delete(int id){ userRepository.deleteById(id); };
}
