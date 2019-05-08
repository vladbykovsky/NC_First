package com.netcracker.edu.vlad.service.impl;

import com.netcracker.edu.vlad.models.User;
import com.netcracker.edu.vlad.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/admin/users/login/" + login, User.class);
        return user;
    }

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/admin/users", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

//    @Override
//    public User save(User user) {
//        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForEntity(backendServerUrl + "/api/admin/users", user, User.class).getBody();
//    }

    @Override
    public void deleteUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/admin/users/" + id);
    }
}
