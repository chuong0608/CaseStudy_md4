package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class LikePlaylist {
    //id	Long
    //type:like/unlike	int
    //playlist	PlayList
    //user	User
    //createAt	Thời gian tạo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type;
    @ManyToOne
    private Playlist playlist;
    @ManyToMany
    private User user;
    private String createAt;

    public LikePlaylist() {
    }

    public LikePlaylist(Long id, int type, Playlist playlist, User user, String createAt) {
        this.id = id;
        this.type = type;
        this.playlist = playlist;
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

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
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
