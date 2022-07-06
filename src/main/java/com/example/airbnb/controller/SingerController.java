package com.example.airbnb.controller;

import com.example.airbnb.model.Singer;
import com.example.airbnb.service.RoleService;
import com.example.airbnb.service.SingerService;
import com.example.airbnb.service.UserService;
import com.example.airbnb.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/api/singer")
public class SingerController {

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SingerService singerService;

    //add new singer
    @PostMapping("/new-singer")
    public ResponseEntity<Singer> addSinger(@RequestBody Singer singer) {
        singerService.save(singer);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    //find all
    @GetMapping("/all")
    public ResponseEntity<Iterable<Singer>> findAll() {
        return new ResponseEntity<>(singerService.findAll(), HttpStatus.OK);
    }
}
