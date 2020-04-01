package com.projectmanager.projectmanager.Services;

import com.projectmanager.projectmanager.Dao.EmployeeRepo;
import com.projectmanager.projectmanager.Dao.Entities.Employee;
import com.projectmanager.projectmanager.Dto.EmployeeProject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.get();
    }

    public Employee reformatEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){
        Employee employee = employeeRepo.findById(id).get();
        if(updatedEmployee.getEmail()!=null){
            employee.setEmail(updatedEmployee.getEmail());
        }
        if(updatedEmployee.getFirstName()!=null){
            employee.setEmail(updatedEmployee.getFirstName());
        }
        if(updatedEmployee.getLastName()!=null){
            employee.setEmail(updatedEmployee.getLastName());
        }
        return employeeRepo.save(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepo.deleteById(id);
    }

    public Iterable<Employee> findPaginatedEmployees(Integer page,Integer size){
        Pageable pageAndSize = PageRequest.of(page,size);
        return employeeRepo.findAll(pageAndSize);
    }


    public List<EmployeeProject> employeeProjects(){
        return employeeRepo.employeeProjects();
    }
}
