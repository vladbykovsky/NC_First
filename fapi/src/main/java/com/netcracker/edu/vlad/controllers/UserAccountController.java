package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.User;
import com.netcracker.edu.vlad.service.UserAccountService;
import com.netcracker.edu.vlad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user-account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> getAllUsers(){
        return userAccountService.findAll();
    }

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userAccountService.findByLogin(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user /*todo server validation*/) {
        if (user != null) {
            return ResponseEntity.ok(userAccountService.saveUser(user));
        }
        return null;
    }
}