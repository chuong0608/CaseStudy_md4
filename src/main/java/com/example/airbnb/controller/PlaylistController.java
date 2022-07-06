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
import org.springframework.web.bind.annotation.*;

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

    //new playlist
    @PostMapping()
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        playlistService.save(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

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

    //sort by likes desc
    @GetMapping("/sortByLikesDesc")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylistByOrderByLikesDesc() {
        Iterable<Playlist> playlists = playlistService.findAllByOrderByLikesDesc();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    //sort by likes asc
    @GetMapping("/sortByLikesAsc")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylistByOrderByLikesAsc() {
        Iterable<Playlist> playlists = playlistService.findAllByOrderByLikesAsc();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    //find playlist by user id
    @GetMapping("/find-by-user-id/{id}")
    public ResponseEntity<Iterable<Playlist>> showAllPlaylistByUserId(@PathVariable Long id) {
        Iterable<Playlist> playlists = playlistService.findAllByUserId(id);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    // list playlist
    @GetMapping("/find-by-name-playlist")
    public ResponseEntity findByNamePlaylist(@RequestParam String name ) {
        Playlist playlist = playlistService.findByName(name);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }


}
