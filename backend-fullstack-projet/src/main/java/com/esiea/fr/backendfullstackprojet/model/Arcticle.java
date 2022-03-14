package com.esiea.fr.backendfullstackprojet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "articles")
public class Arcticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "article_name")
    private String name;
    private String author_name;
    private Long date;
    private String contenu;
    @JsonIgnore
    @ManyToMany(mappedBy = "articles")
    public List<Categorie> categories = new ArrayList<>();

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Arcticle() {
    }

    public Arcticle(long id, String name, String author_name, Long date, String contenu) {
        super();
        this.id = id;
        this.name = name;
        this.author_name = author_name;
        this.date = date;
        this.contenu = contenu;
    }

}
