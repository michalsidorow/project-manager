package com.projectmanager.projectmanager.api.Controller;

import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.Services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    private ProjectService projectService;

    public ProjectApiController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project createProject(@RequestBody @Valid Project project){
        return projectService.saveProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id){
        return projectService.getProjectById(id);
    }

    @PatchMapping(path = "/{id}",consumes = "application/json")
    public Project updateProject(@PathVariable("id") Long id,@RequestBody @Valid Project updatedProject){
        return projectService.updateProject(id,updatedProject);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable("id") Long id){
        projectService.deleteProjectById(id);
    }

}
