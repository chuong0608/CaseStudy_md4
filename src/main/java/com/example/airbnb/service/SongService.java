package com.example.airbnb.service;

import com.example.airbnb.model.Song;
import com.example.airbnb.service.GeneralService;

public interface SongService extends GeneralService<Song> {

    Iterable<Song> top5BestViewsSong();

    Iterable<Song> top5SongsMostLikes();

}
