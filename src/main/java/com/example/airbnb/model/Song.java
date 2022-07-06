package com.example.airbnb.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Song {
//id
//name
//url
//image
//likes
//feedbacks
//user
//singer
//createAt
//views
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String url;

    private String image;

    private int likes;

    private int feedbacks;

    private int views;

    @ManyToOne
    private Singer singer;

    @ManyToOne
    private  User user;

    private LocalDateTime createAt;

    public Song() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
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
