package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.repositoris.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsManager userDetailsManager;

    @PostMapping("/register/")
    public String register(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userDetailsManager.userExists(userRegisterRequest.username)) return
                "ERROR: usuario existente";
        userDetailsManager.createUser(User.builder()
                .username(userRegisterRequest.username)
                .password(passwordEncoder.encode(userRegisterRequest.password))
                .roles("USER")
                .build()
        );
        return "OK";
    }
}