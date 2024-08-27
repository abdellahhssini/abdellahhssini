package com.example.stageproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="projects")
public class Project {
    @Id
    private String _idProject;
    private String name;
    private String _idUser;

    public String get_idProject() {
        return _idProject;
    }

    public void set_idProject(String _idProject) {
        this._idProject = _idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_idUser() {
        return _idUser;
    }

    public void set_idUser(String _idUser) {
        this._idUser = _idUser;
    }
}
