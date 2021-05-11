package org.employee.management.controllers;

import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Local;
import org.employee.management.entities.Employee;
import org.employee.management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    @ResponseBody
    public String welcome() {
        return "Welcome to Employee Management System";
    }

    @GetMapping("/employee")
    @ApiOperation(value = "find all employees", notes = "will fetch all employees form DB", response = Employee.class)
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.size() <= 0) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employees);
    }

    @PostMapping("/employee")
    @ApiOperation(value = "create an employees", notes = "create one employee instance into DB", response = Employee.class)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.saveEmployee(emp);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("/employee")
    @ApiOperation(value = "delete employee", notes = "delete employee from DB", response = Employee.class)
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.deleteEmployee(emp);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/employee")
    @ApiOperation(value = "update employee", notes = "update employee into DB", response = Employee.class)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        Employee employee = employeeService.saveEmployee(emp);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/employee/{id}")
    @ApiOperation(value = "get employee", notes = "get employee DB based on empId", response = Employee.class)
    public ResponseEntity<Employee> findById(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation(value = "delete employee", notes = "delete employee DB based on empId", response = Employee.class)
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.deleteEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    /*@GetMapping("/employee/{fName}/{lName}")
    public ResponseEntity<Employee> findEmpByLastNameBirthDateAndGender(@PathVariable("fName") String firstName, @PathVariable("lName") String lastName) {
        List<Employee> employee = employeeService.findEmpByLastNameAndGender(firstName, lastName);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return null;
    }*/
}
