package org.employee.management.services;

import org.employee.management.entities.Employee;
import org.employee.management.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    public Employee saveEmployee(Employee employee) {
        Employee savedEntity = empRepository.save(employee);
        return savedEntity;
    }
}
