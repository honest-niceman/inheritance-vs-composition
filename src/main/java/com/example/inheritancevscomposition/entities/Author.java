package com.example.inheritancevscomposition.entities;

import com.example.inheritancevscomposition.embeddables.BaseEntityAddress;
import com.example.inheritancevscomposition.embeddables.BaseEntityAudit;
import com.example.inheritancevscomposition.interfaces.EntityWithAddressFields;
import com.example.inheritancevscomposition.interfaces.EntityWithAuditFields;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements EntityWithAuditFields, EntityWithAddressFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Article> articles = new LinkedHashSet<>();

    @Embedded
    private BaseEntityAudit baseEntityAudit;

    @Embedded
    private BaseEntityAddress baseEntityAddress;

    public BaseEntityAddress getBaseEntityAddress() {
        return baseEntityAddress;
    }

    public void setBaseEntityAddress(BaseEntityAddress baseEntityAddress) {
        this.baseEntityAddress = baseEntityAddress;
    }

    public BaseEntityAudit getBaseEntityAudit() {
        return baseEntityAudit;
    }

    public void setBaseEntityAudit(BaseEntityAudit baseEntityAudit) {
        this.baseEntityAudit = baseEntityAudit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}