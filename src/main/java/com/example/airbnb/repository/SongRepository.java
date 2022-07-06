package com.example.airbnb.repository;

import com.example.airbnb.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    Iterable<Song> findByNameContaining(String name);
    Song findByName(String name);

    //find all by views
    Iterable<Song> findAllByOrderByViewsDesc();
    Iterable<Song>  findAllByOrderByViewsAsc();


    Iterable<Song>  findAllBySingerId(Long id);


}
