package com.example.airbnb.service.impl;

import com.example.airbnb.model.Like_Playlist;
import com.example.airbnb.repository.LikePlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LikePlaylistServiceImpl implements com.example.airbnb.service.LikePlaylistService {

    @Autowired
    LikePlaylistRepository likePlaylistRepository;


    @Override
    public void save(Like_Playlist like_playlist) {
        likePlaylistRepository.save(like_playlist);
    }

    @Override
    public void delete(Like_Playlist like_playlist) {

        likePlaylistRepository.delete(like_playlist);
    }

    @Override
    public Iterable<Like_Playlist> findAll() {
        return likePlaylistRepository.findAll();
    }

    @Override
    public Optional<Like_Playlist> findById(Long id) {
        return likePlaylistRepository.findById(id);
    }

    @Override
    public Like_Playlist findByName(String name) {
        return null;
    }


    @Override
    public Like_Playlist findByUserIdAndAndPlayListId(Long userID,Long playlistId){
        return likePlaylistRepository.findByUserIdAndAndPlayListId(userID,playlistId);
    }
}
