package com.example.airbnb.service;


import com.example.airbnb.model.Like_Playlist;

public interface LikePlaylistService extends GeneralService<Like_Playlist> {

    Like_Playlist findByUserIdAndAndPlayListId(Long userID,Long playlistId);
}