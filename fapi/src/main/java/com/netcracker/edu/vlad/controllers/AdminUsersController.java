package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.User;
import com.netcracker.edu.vlad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/users")
public class AdminUsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

//    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
//    public User saveUser(@RequestBody User user){
//        return userService.save(user);
//    }

}
