package com.example.stageproject.controller;

import com.example.stageproject.model.Card;
import com.example.stageproject.model.Project;
import com.example.stageproject.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/allprojects/{_id}")
    public List<Project> getProjects(@PathVariable String _id){
        return projectService.getAllProject(_id);
    }
    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Project newproject){
        Map<String, String> response = new HashMap<>();
        response.put("_id", projectService.save(newproject));
        return response;
    }
    @PutMapping("/edit/{_id}")
    public void update(@PathVariable String _id, @RequestBody Project newproject){
        Optional<Project> project = projectService.findById(_id);
        if(project.isPresent()){
            projectService.update(_id,newproject);
        } else {
            projectService.save(newproject);
        }
    }
    @GetMapping("/cards/{_id}")
    public ResponseEntity<Project> postResponseEntity(@PathVariable String _id){
        Optional<Project> project = projectService.findById(_id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        projectService.delete(_id);
    }
    @GetMapping("/{_id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String _id) {
        Optional<Project> project = projectService.findById(_id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
