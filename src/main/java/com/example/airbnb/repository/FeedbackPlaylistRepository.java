package com.example.airbnb.repository;


import com.example.airbnb.model.Feedback_Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackPlaylistRepository  extends JpaRepository<Feedback_Playlist,Long> {


}
