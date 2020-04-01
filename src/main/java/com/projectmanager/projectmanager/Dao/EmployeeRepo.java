package com.projectmanager.projectmanager.Dao;

import com.projectmanager.projectmanager.Dao.Entities.Employee;
import com.projectmanager.projectmanager.Dto.EmployeeProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "Select e.FIRST_NAME as firstName ,e.last_name as lastName, COUNT(pe.EMPLOYEE_ID ) as projectCount " +
            "FROM employee e left join PROJECT_EMPLOYEE pe ON pe.EMPLOYEE_ID  =  e.ID " +
            "group By e.FIRST_NAME, e.LAST_NAME ORDER By 3 DESC")
    public List<EmployeeProject> employeeProjects();

    Employee findByEmail(String value);

//    Employee findByEmployeeId(Long id);
}
