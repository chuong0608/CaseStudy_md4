package com.example.airbnb.repository;

import com.example.airbnb.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//find by name containing
    Playlist findByNameContaining(String name);

    //all sort by create at
    Iterable<Playlist> findAllByOrderByCreateAtDesc();
    Iterable<Playlist> findAllByOrderByCreateAtAsc();



}
