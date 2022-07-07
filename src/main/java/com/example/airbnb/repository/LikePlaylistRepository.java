package com.example.airbnb.repository;

import com.example.airbnb.model.Like_Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePlaylistRepository extends JpaRepository<Like_Playlist,Long> {


}
