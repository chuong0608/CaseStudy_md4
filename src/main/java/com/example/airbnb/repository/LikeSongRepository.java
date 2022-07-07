package com.example.airbnb.repository;


import com.example.airbnb.model.Like_Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeSongRepository extends JpaRepository<Like_Song,Long> {

    Like_Song findByUserIdAndSongId(Long userId,Long songId);

}
