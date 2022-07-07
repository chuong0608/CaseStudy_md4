package com.example.airbnb.service.impl;


import com.example.airbnb.model.Like_Song;
import com.example.airbnb.repository.LikeSongRepository;
import com.example.airbnb.service.LikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeSongServiceImpl implements LikeSongService {

    @Autowired
    LikeSongRepository likeSongRepository;
    @Override
    public void save(Like_Song like_song) {
        likeSongRepository.save(like_song);
    }

    @Override
    public void delete(Like_Song like_song) {
        likeSongRepository.delete(like_song);

    }

    @Override
    public Iterable<Like_Song> findAll() {
        return likeSongRepository.findAll();
    }

    @Override
    public Optional<Like_Song> findById(Long id) {
        return likeSongRepository.findById(id);
    }

    @Override
    public Like_Song findByName(String name) {
        return null;
    }

    @Override
    public Like_Song findByUserIdAndSongId(Long userId, Long songId) {
        return likeSongRepository.findByUserIdAndSongId(userId,songId);
    }
}
