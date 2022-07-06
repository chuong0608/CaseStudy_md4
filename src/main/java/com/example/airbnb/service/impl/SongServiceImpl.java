package com.example.airbnb.service.impl;

import com.example.airbnb.model.Song;
import com.example.airbnb.repository.SongRepository;
import com.example.airbnb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
@Autowired
private SongRepository songRepository;

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song findByName(String name) {
        return songRepository.findByName(name);
    }
    //find by name containing
    public Iterable<Song> findByNameContaining(String name) {
        return songRepository.findByNameContaining(name);
    }

    //find all by views

    public Iterable<Song> findAllByOrderByViewsDesc() {
        return songRepository.findAllByOrderByViewsDesc();
    }

    public  Iterable<Song> findAllByOrderByViewsAsc() {
        return songRepository.findAllByOrderByViewsAsc();
    }



}
