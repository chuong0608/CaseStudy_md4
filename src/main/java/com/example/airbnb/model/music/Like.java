package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class Like {
    //id	Long
    //type:like/unlike	int
    //song	Song
    //user	User
    //createAt	Thời gian tạo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type;
    @ManyToOne
    private Song song;
    @ManyToMany
    private User user;
    private String createAt;

    public Like() {
    }

    public Like(Long id, int type, Song song, User user, String createAt) {
        this.id = id;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
