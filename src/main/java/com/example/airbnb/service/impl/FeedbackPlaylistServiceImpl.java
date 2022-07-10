package com.example.airbnb.service.impl;


import com.example.airbnb.model.Feedback_Playlist;
import com.example.airbnb.repository.FeedbackPlaylistRepository;
import com.example.airbnb.service.FeedbackPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackPlaylistServiceImpl implements FeedbackPlaylistService {

    @Autowired
    FeedbackPlaylistRepository feedbackPlaylistRepository;

    @Override
    public void save(Feedback_Playlist feedback_playlist) {
        feedbackPlaylistRepository.save(feedback_playlist);

    }

    @Override
    public void delete(Feedback_Playlist feedback_playlist) {
        feedbackPlaylistRepository.delete(feedback_playlist);

    }

    @Override
    public Iterable<Feedback_Playlist> findAll() {
        return feedbackPlaylistRepository.findAll();
    }

    @Override
    public Optional<Feedback_Playlist> findById(Long id) {
        return feedbackPlaylistRepository.findById(id);
    }

    @Override
    public Feedback_Playlist findByName(String name) {
        return null;
    }
}
