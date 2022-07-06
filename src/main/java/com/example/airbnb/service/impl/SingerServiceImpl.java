package com.example.airbnb.service.impl;

import com.example.airbnb.model.Singer;
import com.example.airbnb.model.Song;
import com.example.airbnb.repository.SingerRepository;
import com.example.airbnb.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerServiceImpl implements SingerService {
@Autowired
private SingerRepository singerRepository;

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        singerRepository.delete(singer);
    }

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public Singer findByName(String name) {
        return singerRepository.findByNameContaining(name);
    }
}
