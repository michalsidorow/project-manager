package com.projectmanager.projectmanager.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectmanager.projectmanager.Dao.EmployeeRepo;
import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.Dao.ProjectRepo;
import com.projectmanager.projectmanager.Dto.ChartData;
import com.projectmanager.projectmanager.Dto.EmployeeProject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private EmployeeRepo employeeRepo;
    private ProjectRepo projectRepo;

    public HomeController(EmployeeRepo employeeRepo, ProjectRepo projectRepo) {
        this.employeeRepo = employeeRepo;
        this.projectRepo = projectRepo;
    }

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projectsList", projects);

        List<EmployeeProject> employeesProjectCount = employeeRepo.employeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);

        List<ChartData> projectData = projectRepo.getProjectStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCount",jsonString);

        return "main/home";
    }
}
