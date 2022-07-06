package com.example.airbnb.controller;

import com.example.airbnb.model.Song;
import com.example.airbnb.service.impl.JwtService;
import com.example.airbnb.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/api/song")
public class SongController {
    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private SongServiceImpl songService;

    //find all
    @GetMapping("")
    public ResponseEntity<Iterable<Song>> showAllSong() {
        Iterable<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    //add new song
    @PostMapping("/new-song")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }



}
