package com.example.stageproject.services;

import com.example.stageproject.model.Card;
import com.example.stageproject.model.ListCard;
import com.example.stageproject.repository.ListCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListCardService {
    @Autowired
    private final ListCardRepository listCardRepository;
    public ListCardService(ListCardRepository listCardRepository){
        this.listCardRepository=listCardRepository;
    }
    public String save(ListCard newlistcard){
        ListCard listCard = new ListCard();
        listCard.set_idList(newlistcard.get_idList());
        listCard.setName(newlistcard.getName());
        listCard.set_idProject(newlistcard.get_idProject());
        return listCardRepository.save(listCard).get_idList();
    }
    public List<ListCard> getAll(String _id){
        return this.listCardRepository.findAllBy_idProject(_id);
    }
    public List<ListCard> findByNameLists(String name){
        return listCardRepository.findAllByNameContaining(name);
    }
    public void update(String id, ListCard newListCard){
        Optional<ListCard> listCard = findById(id);
        if(listCard.isPresent()){
            ListCard forUdate = listCard.get();
            forUdate.setName(newListCard.getName());
            forUdate.set_idProject(newListCard.get_idProject());
            listCardRepository.save(forUdate);
        }
    }
    public Optional<ListCard> findById(String id){
        return listCardRepository.findById(id);
    }
    public void delete(String id){
        Optional<ListCard> listCard = findById(id);
        listCard.ifPresent(listCardRepository::delete);
    }
}

