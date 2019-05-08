package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.User;
import com.netcracker.edu.vlad.security.SecurityJwtConstants;
import com.netcracker.edu.vlad.security.TokenProvider;
import com.netcracker.edu.vlad.models.AuthToken;
import com.netcracker.edu.vlad.models.LoginUser;
import com.netcracker.edu.vlad.service.UserAccountService;
import com.netcracker.edu.vlad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//AuthenticationController has API exposed to generate JWT token
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody LoginUser loginUser){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getLogin(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> userAuth(Principal userInfo){
        User user = userAccountService.findByLogin(userInfo.getName());
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}

