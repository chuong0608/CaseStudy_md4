package com.example.airbnb.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Playlist {
//id
//name
//user
//song
//likes
//feedbacks
//createAt

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;

    private int likes;

    private int feedbacks;

    private LocalDateTime createAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(int feedbacks) {
        this.feedbacks = feedbacks;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Playlist() {


    }
}
