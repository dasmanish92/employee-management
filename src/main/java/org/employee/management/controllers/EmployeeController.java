package org.employee.management.controllers;

import org.employee.management.entities.Employee;
import org.employee.management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    @ResponseBody
    public String welcome() {
        return "Welcome to Employee Management System";
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.size() <= 0) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employees);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.saveEmployee(emp);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.deleteEmployee(emp);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.saveEmployee(emp);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.deleteEmployeeById(id);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }
}
