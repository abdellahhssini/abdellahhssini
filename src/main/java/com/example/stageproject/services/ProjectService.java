package com.example.stageproject.services;

import com.example.stageproject.model.Project;
import com.example.stageproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    public List<Project> getAllProject(String _id){
        return this.projectRepository.findAllBy_idUser(_id);
    }
    public String save(Project newproject){
        Project project = new Project();
        project.set_idProject(newproject.get_idProject());
        project.setName(newproject.getName());
        project.set_idUser(newproject.get_idUser());
        return projectRepository.save(project).get_idProject();
    }
    public List<Project> findByNameProjects(String name){
        return projectRepository.findAllByNameContaining(name);
    }
    public void update(String _id, Project newproject){
        Optional<Project> project = findById(_id);
        if(project.isPresent()){
            Project forUpdate = project.get();
            forUpdate.setName(newproject.getName());
            forUpdate.set_idUser(newproject.get_idUser());
            projectRepository.save(forUpdate);
        }
    }
    public void delete(String id){
        Optional<Project> project = findById(id);
        if (project.isPresent()){
            projectRepository.delete(project.get());
        }
    }
    public Optional<Project> findById(String id){
        return projectRepository.findById(id);
    }
}
