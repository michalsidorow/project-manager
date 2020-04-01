//package com.projectmanager.projectmanager.Services;
//
//import com.projectmanager.projectmanager.Dao.EmployeeRepo;
//import com.projectmanager.projectmanager.Dao.Entities.Employee;
//import com.projectmanager.projectmanager.Dao.Entities.Project;
//import com.projectmanager.projectmanager.Dao.ProjectRepo;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class DBService {
//
//    private EmployeeRepo employeeRepo;
//    private ProjectRepo projectRepo;
//
//    public DBService(EmployeeRepo employeeRepo, ProjectRepo projectRepo) {
//        this.employeeRepo = employeeRepo;
//        this.projectRepo = projectRepo;
//    }
//
//    public Employee save(Employee employee){
//        return employeeRepo.save(employee);
//    }
//
//    public Project save(Project project){
//        return projectRepo.save(project);
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
//        Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
//        Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");
//        Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//        Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
//        Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");
//        Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
//        Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
//        Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");
//
//        Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//                + "the final deployment of the software into production");
//        Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
//                + "for the year and figureout who will be promoted");
//        Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//                + "been damaged due to hurricane in the region. This needs to be reconstructed");
//        Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
//                + "security needs to be improved and proper security team needs to be hired for "
//                + "implementation");
//
//        pro1.setEmployees(Arrays.asList(emp1,emp2));
//        pro2.setEmployees(Arrays.asList(emp3));
//        pro3.setEmployees(Arrays.asList(emp1));
//        pro4.setEmployees(Arrays.asList(emp1,emp3));
//
//        emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//        emp2.setProjects(Arrays.asList(pro1));
//        emp3.setProjects(Arrays.asList(pro2, pro4));
//
//        save(emp1);
//        save(emp2);
//        save(emp3);
//        save(emp4);
//        save(emp5);
//        save(emp6);
//        save(emp7);
//        save(emp8);
//        save(emp9);
//        save(pro1);
//        save(pro2);
//        save(pro3);
//        save(pro4);
//
//
//    }
//}
