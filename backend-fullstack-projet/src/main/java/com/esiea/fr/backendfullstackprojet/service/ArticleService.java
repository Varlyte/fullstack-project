package com.esiea.fr.backendfullstackprojet.service;

import com.esiea.fr.backendfullstackprojet.model.Arcticle;
import com.esiea.fr.backendfullstackprojet.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<Arcticle> getArticles(){
        return articleRepository.findAll();
    }

    public Arcticle getArticle(Long id) throws NotFoundException{
        Optional<Arcticle> res = articleRepository.findById(id);
        if (res.isPresent()){
            return res.get();
        }
        else {
            throw new NotFoundException();
        }
    }

    public Arcticle Create(Arcticle arcticle) throws NotAllowedException{
        if ( arcticle.getId()== null )
            articleRepository.save(arcticle);
        throw new NotAllowedException();
    }

    public Arcticle Update(Arcticle arcticle) {
        try {
            getArticle(arcticle.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return articleRepository.save(arcticle);
    }

    public void Delete(Long id) throws NotFoundException{
        try {
            articleRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            logger.warn(id + " not found");
            throw new NotFoundException();
        }
    }
    public Arcticle GetbyAuthorName(String author_name) throws NotFoundException{
        Optional<Arcticle> arcticle = articleRepository.findByName(author_name);
        if (arcticle.isPresent()){
            return arcticle.get();
        }
        throw new NotFoundException();
    }
}
