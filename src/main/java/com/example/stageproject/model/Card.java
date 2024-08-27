package com.example.stageproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cards")
public class Card {
    @Id
    private String _id;
    private String contenu;
    private String _idListCard;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_idListCard() {
        return _idListCard;
    }

    public void set_idListCard(String _idListCard) {
        this._idListCard = _idListCard;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
