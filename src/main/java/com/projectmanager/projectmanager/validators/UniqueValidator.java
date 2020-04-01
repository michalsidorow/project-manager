package com.projectmanager.projectmanager.validators;

import com.projectmanager.projectmanager.Dao.EmployeeRepo;
import com.projectmanager.projectmanager.Dao.Entities.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    private EmployeeRepo employeeRepo;

    public UniqueValidator(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Entered validation method");

        Employee employee = employeeRepo.findByEmail(s);

        if (employee != null)
            return false;
        else
            return true;
    }
}
