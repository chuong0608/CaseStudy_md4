package com.example.airbnb.controller;

import com.example.airbnb.model.Like_Playlist;
import com.example.airbnb.model.Playlist;
import com.example.airbnb.model.User;
import com.example.airbnb.service.LikePlaylistService;
import com.example.airbnb.service.SongService;
import com.example.airbnb.service.UserService;
import com.example.airbnb.service.impl.JwtService;
import com.example.airbnb.service.impl.PlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/api/like-playlist")
public class LikePlaylistCongtroller {


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
    LikePlaylistService likePlaylistService;

    @Autowired
    UserService userService;

    private boolean checkLike(User user, Playlist playlist, Iterable<Like_Playlist> like_playlists) {
        for (Like_Playlist i : like_playlists) {
            if (i.getPlayList() == playlist && i.getUser()==user && i.getType()) {
                return false;
            }
        }
        return true;
    }
    @PostMapping("like-playlist/{idPlaylist}/{idUser}")
    public ResponseEntity<Playlist> addLikePlaylist(@PathVariable Long idPlaylist, @PathVariable Long idUser) {
        Like_Playlist like_playlist = new Like_Playlist();
        Playlist playlistOptional = playlistService.findById(idPlaylist).get();
        User userOptional = userService.findById(idUser).get();
        Like_Playlist lastLike= likePlaylistService.findByUserIdAndAndPlayListId(userOptional.getId(),playlistOptional.getId());
        if(checkLike(userOptional,playlistOptional,likePlaylistService.findAll())) {
            if (lastLike == null) {
                like_playlist.setPlayList(playlistOptional);
                like_playlist.setUser(userOptional);
                like_playlist.setType(true);
                likePlaylistService.save(like_playlist);
            }else{
                lastLike.setType(true);
                likePlaylistService.save(like_playlist);
            }
        }

        int oldLikes = playlistOptional.getLikes();
        oldLikes = oldLikes == 0 ? 0:oldLikes;
        playlistOptional.setLikes(oldLikes+1);
        playlistService.save(playlistOptional);
        return new ResponseEntity(playlistOptional, HttpStatus.OK);
    }

}
