package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class FeedbackPlaylist {
    //id	Long
    //comment	nội dung
    //playlist	PlayList
    //user	User
    //createAt	Thời gian tạo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    private Playlist playlist;
    @ManyToMany
    private User user;
    private String createAt;

    public FeedbackPlaylist() {
    }

    public FeedbackPlaylist(Long id, String comment, Playlist playlist, User user, String createAt) {
        this.id = id;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
