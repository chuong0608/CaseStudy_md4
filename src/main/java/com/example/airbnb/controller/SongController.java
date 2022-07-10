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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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
        LocalDateTime localDateTime = LocalDateTime.now();
        song.setCreateAt(localDateTime);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    //find all by views
    @GetMapping("/all-by-views-desc")
    public ResponseEntity<Iterable<Song>> showAllSongByViews() {
        Iterable<Song> songs = songService.findAllByOrderByViewsDesc();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    //find all by views
    @GetMapping("/all-by-views-asc")
    public ResponseEntity<Iterable<Song>> showAllSongByViewsAsc() {
        Iterable<Song> songs = songService.findAllByOrderByViewsAsc();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    //update song
    @PutMapping("/update-song/{id}")
    public ResponseEntity<Song> updateSong(@RequestBody Song song,@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (!songOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        song.setId(songOptional.get().getId());
        LocalDateTime localDateTime = LocalDateTime.now();
        song.setCreateAt(localDateTime);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    // song by singer
    @GetMapping("/all-song-by-singer/{id}")
    public ResponseEntity<Iterable<Song>> findAllBySingerId(@PathVariable Long id) {
        Iterable<Song> songs = songService.findAllBySingerId(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    // list song by createAt desc
    @GetMapping("/list-song-by-create-desc")
    public ResponseEntity<Iterable<Song>> findAllBySingerId() {
        Iterable<Song> songs = songService.findAllByCreateAtDesc();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }


    // top 5 song views most
    @GetMapping("/top5-song-most-views")
    public ResponseEntity<Iterable<Song>> top5ViewsSong() {
        Iterable<Song> songs = songService.top5BestViewsSong();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    // top 5 song likes most

    @GetMapping("/top5-song-most-like")
    public ResponseEntity<Iterable<Song>> top5SongMostViews(){
        Iterable<Song> songs = songService.top5SongsMostLikes();
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }

    //find by name containing
    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<?> findByNameContaining(@PathVariable String name) {
        Iterable<Song> song = songService.findByNameContaining(name);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    //delete song by user id








}
