package com.example.airbnb.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Feedback_Playlist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String comment;

    @ManyToOne
    private PlayList playList;

    @ManyToOne
    private User user;

    private LocalDateTime createAt;

    public Feedback_Playlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
