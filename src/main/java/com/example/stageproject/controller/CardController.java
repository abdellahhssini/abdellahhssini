package com.example.stageproject.controller;

import com.example.stageproject.model.Card;
import com.example.stageproject.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/search")
    public List<Card> getCardsByContenu(@RequestParam(required = false) String contenu){
        if(StringUtils.isEmpty(contenu)){
            return cardService.getAll();
        }
        return cardService.findByContenuCards(contenu);
    }

    @GetMapping("/all/{_idListCard}")
    public List<Card> get(@PathVariable String _idListCard){
        return cardService.findCardsByIdListCard(_idListCard);
    }

    @PostMapping("/cards/add")
    public Map<String, String> save(@RequestBody Card newcard){
        Map<String, String> response = new HashMap<>();
        response.put("_id", cardService.save(newcard));
        return response;
    }
    @PutMapping("/cards/edit/{_id}")
    public void update(@PathVariable String _id,@RequestBody Card newcard){
        Optional<Card> card = cardService.findById(_id);
        if(card.isPresent()){
            cardService.update(_id,newcard);
        } else {
            cardService.save(newcard);
        }
    }
    @GetMapping("/cards/{_id}")
    public ResponseEntity<Card> postResponseEntity(@PathVariable String _id){
        Optional<Card> card = cardService.findById(_id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cards/delete/{_id}")
    public void delete(@PathVariable String _id){
        cardService.delete(_id);
    }
}
