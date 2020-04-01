package com.projectmanager.projectmanager.Controllers;

import com.projectmanager.projectmanager.Dao.Entities.Employee;
import com.projectmanager.projectmanager.Services.EmployeeService;
import com.projectmanager.projectmanager.Services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private ProjectService projectService;

    public EmployeeController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeesForm(Model model) {

        Employee anEmployee = new Employee();

        model.addAttribute("employee", anEmployee);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
}
