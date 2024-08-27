package com.example.stageproject.repository;

import com.example.stageproject.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card,String> {
    List<Card> findAllByContenuContaining(String contenu);
    List<Card> findAllBy_idListCard(String _idLIstCard);
}
