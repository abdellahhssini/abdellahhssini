package com.example.stageproject.repository;

import com.example.stageproject.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findAllByNameContaining(String name);
    List<Project> findAllBy_idUser(String _idUser);
}
