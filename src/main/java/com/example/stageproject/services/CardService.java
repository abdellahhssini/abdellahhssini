package com.example.stageproject.services;

import com.example.stageproject.model.Card;
import com.example.stageproject.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public List<Card> getAll(){
        return this.cardRepository.findAll();
    }
    public String save(Card newcard){
        Card card = new Card();
        card.set_id(newcard.get_id());;
        card.setContenu(newcard.getContenu());
        card.set_idListCard(newcard.get_idListCard());
        return cardRepository.save(card).get_id();
    }

    public List<Card> findCardsByIdListCard(String _idListCard){
        return cardRepository.findAllBy_idListCard(_idListCard);
    }

    public List<Card> findByContenuCards(String contenu){
        return cardRepository.findAllByContenuContaining(contenu);
    }

    public void update(String _id, Card newcard){
        Optional<Card> card = findById(_id);
        if(card.isPresent()){
            Card forUpdate = card.get();
            forUpdate.setContenu(newcard.getContenu());
            forUpdate.set_idListCard(newcard.get_idListCard());
            cardRepository.save(forUpdate);
        }
    }
    public Optional<Card> findById(String _id){
        return cardRepository.findById(_id);
    }
    public void delete(String _id){
        Optional<Card> card = findById(_id);
        if(card.isPresent()){
            cardRepository.delete(card.get());
        }
    }
}
