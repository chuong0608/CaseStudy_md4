package com.example.airbnb.repository;

import com.example.airbnb.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    Song findByNameContaining(String name);
}
