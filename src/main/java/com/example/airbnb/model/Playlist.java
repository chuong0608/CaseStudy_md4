package com.example.airbnb.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private int likes;

    private int feedbacks;

    private LocalDateTime createAt;



    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> songList;


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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
    public Playlist() {


    }
}
