package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class FeedbackSong {
    //id	Long
    //comment	nội dung
    //song	Song
    //user	User
    //createAt	Thời gian tạo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    private Song song;
    @ManyToMany
    private User user;
    private String createAt;

    public FeedbackSong() {
    }

    public FeedbackSong(Long id, String comment, Song song, User user, String createAt) {
        this.id = id;
        this.comment = comment;
        this.song = song;
        this.user = user;
        this.createAt = createAt;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
