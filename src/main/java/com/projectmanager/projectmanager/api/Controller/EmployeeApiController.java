package com.projectmanager.projectmanager.api.Controller;

import com.projectmanager.projectmanager.Dao.Entities.Employee;
import com.projectmanager.projectmanager.Services.EmployeeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    private EmployeeService employeeService;

    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee updateRecord(@RequestBody @Valid Employee employee) {
        return employeeService.reformatEmployee(employee);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody @Valid Employee patchEmployee) {
        return employeeService.updateEmployee(id, patchEmployee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable("id") Long id){
        try {
            employeeService.deleteEmployeeById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }

    @GetMapping(params = {"page","size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") Integer page,@RequestParam("size") Integer size){
        return employeeService.findPaginatedEmployees(page, size);
    }
}
