package org.employee.management.services;

import org.employee.management.entities.Employee;
import org.employee.management.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    public Employee saveEmployee(Employee employee) {
        Employee savedEntity = empRepository.save(employee);
        return savedEntity;
    }

    public Employee findById(int id) {
        Employee employee = empRepository.findById(id);
        return employee;
    }

    public List<Employee> findAllEmployees() {
        List<Employee> employees = (List<Employee>) empRepository.findAll();
        return employees;
    }

    public Employee deleteEmployee(Employee emp) {
        empRepository.delete(emp);
        return emp;
    }

    public Employee deleteEmployeeById(int id) {
        Employee employee = empRepository.deleteById(id);
        return employee;
    }

    /*public List<Employee> findEmpByLastNameAndGender(String fName, String lName) {
        List<Employee> employees = empRepository.findAllByLastName(fName, lName);
        return null;
    }*/

}
