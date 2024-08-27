package com.example.stageproject.repository;

import com.example.stageproject.model.ListCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListCardRepository extends MongoRepository<ListCard,String> {
    List<ListCard> findAllByNameContaining(String name);
    List<ListCard> findAllBy_idProject(String _id);
}
