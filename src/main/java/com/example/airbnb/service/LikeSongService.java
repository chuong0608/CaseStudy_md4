package com.example.airbnb.service;

import com.example.airbnb.model.Like_Song;

public interface LikeSongService extends GeneralService<Like_Song> {

    Like_Song findByUserIdAndSongId(Long userId,Long songId);
}
