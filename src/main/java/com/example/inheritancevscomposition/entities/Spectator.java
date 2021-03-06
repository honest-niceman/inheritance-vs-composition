package com.example.inheritancevscomposition.entities;

import com.example.inheritancevscomposition.embeddables.BaseEntityAddress;
import com.example.inheritancevscomposition.interfaces.EntityWithAddressFields;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spectator")
public class Spectator implements EntityWithAddressFields {
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

    @Embedded
    private BaseEntityAddress baseEntityAddress;

    public BaseEntityAddress getBaseEntityAddress() {
        return baseEntityAddress;
    }

    public void setBaseEntityAddress(BaseEntityAddress baseEntityAddress) {
        this.baseEntityAddress = baseEntityAddress;
    }

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