package com.example.airbnb.controller;

import com.example.airbnb.model.*;
import com.example.airbnb.service.LikePlaylistService;
import com.example.airbnb.service.LikeSongService;
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

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/api/like")
public class LikeController {


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
    LikeSongService likeSongService;


    @Autowired
    LikePlaylistService likePlaylistService;


    @Autowired
    UserService userService;

    private boolean checkLikePlaylist(User user, Playlist playlist, Iterable<Like_Playlist> like_playlists) {
        for (Like_Playlist i : like_playlists) {
            if (i.getPlayList() == playlist && i.getUser()==user && i.getType()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLikeSong(User user, Song song, Iterable<Like_Song> like_songs) {
        for (Like_Song i : like_songs) {
            if (i.getSong() == song && i.getUser()==user && i.getType()) {
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
        if(checkLikePlaylist(userOptional,playlistOptional,likePlaylistService.findAll())) {
            if (lastLike == null) {
                like_playlist.setPlayList(playlistOptional);
                like_playlist.setUser(userOptional);
                like_playlist.setType(true);
                likePlaylistService.save(like_playlist);
            }else{
                lastLike.setType(true);
                likePlaylistService.save(lastLike);
            }
            int oldLikes = playlistOptional.getLikes();
            oldLikes = oldLikes == 0 ? 0:oldLikes;
            playlistOptional.setLikes(oldLikes+1);
            playlistService.save(playlistOptional);
        }

        return new ResponseEntity(playlistOptional, HttpStatus.OK);
    }

    @PostMapping("dislike-playlist/{idPlaylist}/{idUser}")
    public ResponseEntity<Playlist> disLikePlaylist(@PathVariable Long idPlaylist, @PathVariable Long idUser) {
        Like_Playlist like_playlist = new Like_Playlist();
        Playlist playlistOptional = playlistService.findById(idPlaylist).get();
        User userOptional = userService.findById(idUser).get();
        Like_Playlist lastLike= likePlaylistService.findByUserIdAndAndPlayListId(userOptional.getId(),playlistOptional.getId());
        if(!checkLikePlaylist(userOptional,playlistOptional,likePlaylistService.findAll())) {
            lastLike.setType(false);
            int oldLikes = playlistOptional.getLikes();
            oldLikes = oldLikes == 0 ? 0:oldLikes;
            playlistOptional.setLikes(oldLikes-1);
            likePlaylistService.save(like_playlist);
        }
        playlistService.save(playlistOptional);
        return new ResponseEntity(playlistOptional, HttpStatus.OK);
    }

    @PostMapping("like-song/{idSong}/{idUser}")
    public ResponseEntity<Song> likeSong(@PathVariable Long idSong, @PathVariable Long idUser) {
        Like_Song like_song = new Like_Song();
        Song song = songService.findById(idSong).get();
        User user = userService.findById(idUser).get();
        Like_Song lastLikeSong= likeSongService.findByUserIdAndSongId(user.getId(),song.getId());
        if(checkLikeSong(user,song,likeSongService.findAll())) {
            if (lastLikeSong == null) {
                like_song.setSong(song);
                like_song.setUser(user);
                like_song.setType(true);
                likeSongService.save(like_song);
            }else{
                lastLikeSong.setType(true);
                likeSongService.save(lastLikeSong);
            }
            int oldLikes = song.getLikes();
            oldLikes = oldLikes == 0 ? 0:oldLikes;
            song.setLikes(oldLikes+1);
            songService.save(song);
        }

        return new ResponseEntity(song, HttpStatus.OK);
    }

    @PostMapping("dislike-song/{idSong}/{idUser}")
    public ResponseEntity<Song> disLikeSong(@PathVariable Long idSong, @PathVariable Long idUser) {
        Like_Song like_song = new Like_Song();
        Song song = songService.findById(idSong).get();
        User user = userService.findById(idUser).get();
        Like_Song lastLikeSong= likeSongService.findByUserIdAndSongId(user.getId(),song.getId());
        if(!checkLikeSong(user,song,likeSongService.findAll())) {
            lastLikeSong.setType(false);
            int oldLikes = song.getLikes();
            oldLikes = oldLikes == 0 ? 0:oldLikes;
            song.setLikes(oldLikes-1);
            likeSongService.save(like_song);
        }
        songService.save(song);
        return new ResponseEntity(song, HttpStatus.OK);
    }



}
