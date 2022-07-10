package com.example.airbnb.controller;


import com.example.airbnb.model.Feedback_Playlist;
import com.example.airbnb.model.Song;
import com.example.airbnb.service.*;
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
@RequestMapping("/api/feedbacks")
public class FeedbackPlaylistController {

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private PlaylistServiceImpl playlistService;


    @Autowired
    SongService songService;

    @Autowired
    FeedbackPlaylistService feedbackPlaylistService;


    @Autowired
    LikePlaylistService likePlaylistService;


    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<Feedback_Playlist> findAllFeedbackPlaylist(){
       Iterable<Feedback_Playlist> feedback_playlists= feedbackPlaylistService.findAll();
        return new ResponseEntity(feedback_playlists,HttpStatus.OK);
    }

    // new feedback
    @PostMapping("")
    public ResponseEntity<Feedback_Playlist> feedbackPlaylist(@RequestBody Feedback_Playlist feedback_playlist) {
        feedbackPlaylistService.save(feedback_playlist);
        return new ResponseEntity<>(feedback_playlist, HttpStatus.OK);
    }


}
