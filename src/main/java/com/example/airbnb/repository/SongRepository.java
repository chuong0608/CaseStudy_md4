package com.example.airbnb.repository;

import com.example.airbnb.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    Iterable<Song> findByNameContaining(String name);
    Song findByName(String name);

    //find all by views
    Iterable<Song> findAllByOrderByViewsDesc();
    Iterable<Song>  findAllByOrderByViewsAsc();


    Iterable<Song>  findAllBySingerId(Long id);

    @Query(value = "select * from song where create_at order by create_at desc",nativeQuery = true)
    Iterable<Song> findAllByCreateAtDesc();

    @Query(value = "select * from song  order by views desc limit 5",nativeQuery = true)
    Iterable<Song> top5BestViewsSong();

    @Query(value = "select * from song order by likes desc limit 5",nativeQuery = true)
    Iterable<Song> top5SongsMostLikes();




}
