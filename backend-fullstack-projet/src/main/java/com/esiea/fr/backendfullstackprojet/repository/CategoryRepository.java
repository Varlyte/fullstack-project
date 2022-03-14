package com.esiea.fr.backendfullstackprojet.repository;

import com.esiea.fr.backendfullstackprojet.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends CrudRepository<Categorie, Long> {
}
