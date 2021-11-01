package com.example.pathfinder.models.enums.entities;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    @Column
   private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Route route;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
