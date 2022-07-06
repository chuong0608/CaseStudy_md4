package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class Playlist {
    //id	Long
    //name	Tên
    //user	Tác giả
    //song	Song
    //likes	số lượng like
    //feedbacks	Số lượng feedback
    //createAt	Thời gian tạo
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToMany
    private Song song;
    private int likes;
    private int feedbacks;
    private String createAt;

    public Playlist() {
    }

    public Playlist(Long id, String name, User user, Song song, int likes, int feedbacks, String createAt) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.song = song;
        this.likes = likes;
        this.feedbacks = feedbacks;
        this.createAt = createAt;
    }

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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
