package com.esiea.fr.backendfullstackprojet.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String name;

    @ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "catégori_article", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "artcile_id"))
    private List<Arcticle> arcticles = new ArrayList<>();

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

    public List<Arcticle> getArcticles() {
        return arcticles;
    }

    public void setArcticles(List<Arcticle> arcticles) {
        this.arcticles = arcticles;
    }

    public Categorie() {
    }

    public Categorie(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public void AddArticle(Arcticle article){
        arcticles.add(article);
    }
    public void RemoveArticle(Arcticle arcticle){
        arcticles.remove(arcticle);
    }
}
