package com.projectmanager.projectmanager.Controllers;

import com.projectmanager.projectmanager.Dao.EmployeeRepo;
import com.projectmanager.projectmanager.Dao.Entities.Employee;
import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.Dao.ProjectRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private EmployeeRepo employeeRepo;
    private ProjectRepo projectRepo;

    public ProjectController(EmployeeRepo employeeRepo, ProjectRepo projectRepo) {
        this.employeeRepo = employeeRepo;
        this.projectRepo = projectRepo;
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayEmployeesForm(Model model) {
        Project project = new Project();
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("project", project);
        model.addAttribute("employees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Model model,Project project){
        projectRepo.save(project);
        return "redirect:/projects";
    }

}
