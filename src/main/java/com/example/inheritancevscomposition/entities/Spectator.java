package com.example.inheritancevscomposition.entities;

import com.example.inheritancevscomposition.mappedsupperclasses.BaseEntityAuditAddress;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spectator")
public class Spectator extends BaseEntityAuditAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToMany
    @JoinTable(name = "liked_articles",
            joinColumns = @JoinColumn(name = "spectator_id"),
            inverseJoinColumns = @JoinColumn(name = "articles_id"))
    private List<Article> likedArticles = new ArrayList<>();

    public List<Article> getLikedArticles() {
        return likedArticles;
    }

    public void setLikedArticles(List<Article> likedArticles) {
        this.likedArticles = likedArticles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}