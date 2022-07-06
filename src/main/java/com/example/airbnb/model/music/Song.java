package com.example.airbnb.model.music;

import com.example.airbnb.model.User;

import javax.persistence.*;

@Entity
public class Song {
    //id	Long
    //name	tên bài hát
    //url	link nhạc
    //image	link ảnh
    //likes	số lượng like
    //feedbacks	Số lượng feedback
    //user	Tác giả
    //singer	ca sĩ
    //createAt	Thời gian tạo
    //views	số lượng view
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String image;
    private int likes;
    private int feedbacks;
    @ManyToOne
    private User user;
    private String singer;
    private String createAt;
    private int views;

    public Song() {
    }

    public Song(Long id, String name, String url, String image, int likes, int feedbacks, User user, String singer, String createAt, int views
    ) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.image = image;
        this.likes = likes;
        this.feedbacks = feedbacks;
        this.user = user;
        this.singer = singer;
        this.createAt = createAt;
        this.views = views;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
