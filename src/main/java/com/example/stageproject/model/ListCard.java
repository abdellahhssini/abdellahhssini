package com.example.stageproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="lists")
public class ListCard {
    @Id
    private String _idList;
    private String name;
    private String _idProject;

    public String get_idList() {
        return _idList;
    }

    public void set_idList(String _idList) {
        this._idList = _idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_idProject() {
        return _idProject;
    }

    public void set_idProject(String _idProject) {
        this._idProject = _idProject;
    }
}
