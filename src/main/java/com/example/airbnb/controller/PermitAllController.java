package com.example.airbnb.controller;

import com.example.airbnb.model.*;
import com.example.airbnb.service.*;
import com.example.airbnb.service.impl.JwtService;
import com.example.airbnb.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class PermitAllController {
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
    private SongServiceImpl songService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SingerService singerService;




    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Iterable<User> users = userService.findAll();
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        if (!userService.isCorrectConfirmPassword(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (user.getRoles() != null) {
            Role role = roleService.findByName("ROLE_ADMIN");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {
            Role role1 = roleService.findByName("ROLE_USER");
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role1);
            user.setRoles(roles1);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

//save new song
    @PostMapping("/song")
    public ResponseEntity<?> createSong(@RequestBody Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }

    //find by name containing
    @GetMapping("/song/{name}")
    public ResponseEntity<?> findByNameContaining(@PathVariable String name) {
        Iterable<Song> song = songService.findByNameContaining(name);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    //top 5 song views most
    @GetMapping("/song/top5-song-most-views")
    public ResponseEntity<Iterable<Song>> top5ViewsSong() {
        Iterable<Song> songs = songService.top5BestViewsSong();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    // list song by createAt desc
    @GetMapping("/song/list-song-by-create-desc")
    public ResponseEntity<Iterable<Song>> findAllBySingerId() {
        Iterable<Song> songs = songService.findAllByCreateAtDesc();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    //top5 song like most
    @GetMapping("/song/top5-song-most-like")
    public ResponseEntity<Iterable<Song>> top5SongMostViews(){
        Iterable<Song> songs = songService.top5SongsMostLikes();
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }

    //top3 playlists like most
    @GetMapping("/playlists/top3-playlists-most-like")
    public ResponseEntity<Iterable<Playlist>> top3PlaylistsMostViews(){
        Iterable<Playlist> playlists = playlistService.top3PlaylistsOrderByLikesDesc();
        return new ResponseEntity<>(playlists,HttpStatus.OK);
    }

    // find by name singer
    @GetMapping("/singer/find-by-name-singer")
    public  ResponseEntity findByNameSinger(@RequestParam String name){
        Singer singer = singerService.findByName(name);
        return new ResponseEntity<>(singer,HttpStatus.OK);
    }


}
