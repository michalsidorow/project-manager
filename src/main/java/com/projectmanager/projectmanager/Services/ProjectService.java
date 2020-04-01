package com.projectmanager.projectmanager.Services;

import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.Dao.ProjectRepo;
import com.projectmanager.projectmanager.Dto.ChartData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    private ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }

    public List<Project> getAll(){
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepo.findById(id).get();
    }

    public Project updateProject(Long id,Project updatedProject){

        Project project = getProjectById(id);

        if(project.getName()!=null){
            project.setName(updatedProject.getName());
        }
        if(project.getDescription()!=null){
            project.setDescription(updatedProject.getDescription());
        }
        if(project.getStage()!=null){
            project.setStage(updatedProject.getStage());
        }
        return project;
    }

    public void deleteProjectById(Long id){
        projectRepo.deleteById(id);
    }

    public List<ChartData> ProjectProjects(){
        return projectRepo.getProjectStatus();
    }


}
