package com.example.stageproject.controller;

import com.example.stageproject.model.Card;
import com.example.stageproject.model.ListCard;
import com.example.stageproject.services.ListCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/lists")
public class ListCardController {
    private ListCardService listCardService;

    public ListCardController(ListCardService listCardService){
        this.listCardService = listCardService;
    }
    @GetMapping("/all/{_idProject}")
    public List<ListCard> getlist(@PathVariable String _idProject){
        return listCardService.getAll(_idProject);
    }
    @PostMapping("/addlist")
    public Map<String, String> save(@RequestBody ListCard newListCard){
        Map<String, String> response = new HashMap<>();
        response.put("_id", listCardService.save(newListCard));
        return response;
    }

    @PutMapping("/editlists/{_id}")
    public void update(@PathVariable String _id, @RequestBody ListCard newListCard){
        Optional<ListCard> listCard = listCardService.findById(_id);
        if(listCard.isPresent()){
            listCardService.update(_id, newListCard);
        } else {
            listCardService.save(newListCard);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ListCard> postResponseEntity(@PathVariable String id){
        Optional<ListCard> listCard = listCardService.findById(id);
        return listCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletelists/{id}")
    public void delete(@PathVariable String id){
        listCardService.delete(id);
    }
}

