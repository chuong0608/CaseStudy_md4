package com.example.airbnb.service.impl;

import com.example.airbnb.model.Playlist;
import com.example.airbnb.repository.PlaylistRepository;
import com.example.airbnb.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PlaylistServiceImpl implements PlaylistService {
@Autowired
private PlaylistRepository playlistRepository;

    @Override
    public void save(Playlist playList) {
        playlistRepository.save(playList);
    }

    @Override
    public void delete(Playlist playList) {
        playlistRepository.delete(playList);
    }

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist findByName(String name) {
        return playlistRepository.findByNameContaining(name);
    }

    //sort by create at
    public Iterable<Playlist> findAllByOrderByCreateAtDesc() {
        return playlistRepository.findAllByOrderByCreateAtDesc();
    }

    public Iterable<Playlist> findAllByOrderByCreateAtAsc() {
        return playlistRepository.findAllByOrderByCreateAtAsc();
    }

    //sort by likes
    public Iterable<Playlist> findAllByOrderByLikesDesc() {
        return playlistRepository.findAllByOrderByLikesDesc();
    }

    public Iterable<Playlist> findAllByOrderByLikesAsc() {
        return playlistRepository.findAllByOrderByLikesAsc();
    }

    //find playlist by user id
    public Iterable<Playlist> findAllByUserId(Long id) {
        return playlistRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Playlist> top3PlaylistsOrderByLikesDesc() {
        return playlistRepository.top3PlaylistsOrderByLikesDesc();
    }
}
