package com.esiea.fr.backendfullstackprojet.repository;

import com.esiea.fr.backendfullstackprojet.model.Arcticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends CrudRepository<Arcticle, Long> {

    public Optional<Arcticle> findByName(String name);
}
