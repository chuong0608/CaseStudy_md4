package com.example.airbnb.controller;

import com.example.airbnb.model.Playlist;
import com.example.airbnb.service.PlaylistService;
import com.example.airbnb.service.impl.JwtService;
import com.example.airbnb.service.impl.PlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private PlaylistServiceImpl playlistService;

//find all
    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylist() {
        Iterable<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }


    //sort by create at desc
    @GetMapping("/sortByCreateAtDesc")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylistByOrderByCreateAtDesc() {
        Iterable<Playlist> playlists = playlistService.findAllByOrderByCreateAtDesc();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    //sort by create at asc

    @GetMapping("/sortByCreateAtAsc")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylistByOrderByCreateAtAsc() {
        Iterable<Playlist> playlists = playlistService.findAllByOrderByCreateAtAsc();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }


}
