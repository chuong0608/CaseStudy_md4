package com.example.airbnb.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Like_Playlist {

    //id
    //type:like/unlike
    //playlist
    //user
    //createAt

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createAt;

    @ManyToOne
    private Playlist playList;


    @ManyToOne
    private User user;

    private Boolean type;

    public Like_Playlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Playlist getPlayList() {
        return playList;
    }

    public void setPlayList(Playlist playList) {
        this.playList = playList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
