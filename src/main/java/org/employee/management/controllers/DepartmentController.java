package org.employee.management.controllers;

import io.swagger.annotations.ApiOperation;
import org.employee.management.entities.Department;
import org.employee.management.exception.InternalServerException;
import org.employee.management.exception.RecordNotFoundException;
import org.employee.management.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    @ApiOperation(value = "find all departments", notes = "will fetch all departments form DB", response = Department.class)
    public ResponseEntity<List<Department>> findAllDepartments() throws Exception {
        List<Department> departments = departmentService.findAllEmployees();
        if (departments.size() <= 0) {
            throw new RecordNotFoundException("Record Not Found into Database");
            //ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(departments);
    }
    @PostMapping("/department")
    @ApiOperation(value = "create a department", notes = "create a department instance into DB", response = Department.class)
    public ResponseEntity<Department> saveDepartments(@RequestBody Department department) {
        Department dept = departmentService.saveDepartment(department);
        if (dept == null) {
            throw new InternalServerException("Internal Server Error");
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @DeleteMapping("/department")
    @ApiOperation(value = "delete department", notes = "delete department from DB", response = Department.class)
    public ResponseEntity<Department> deleteEmployee(@RequestBody Department department) {
        Department dept = departmentService.deleteEmployee(department);
        if (dept == null) {
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            throw new InternalServerException("Internal Server Error");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @PutMapping("/department")
    @ApiOperation(value = "update department", notes = "update department into DB", response = Department.class)
    public ResponseEntity<Department> updateEmployee(@RequestBody Department department) {
        Department dept = departmentService.saveDepartment(department);
        if (dept == null) {
            throw new InternalServerException("Department could not updated into database");
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @GetMapping("/department/{id}")
    @ApiOperation(value = "get department by id", notes = "get department DB based on empId", response = Department.class)
    public ResponseEntity<Department> findById(@PathVariable("id") int id) {
        Department department = departmentService.findById(id);
        if (department == null) {
            throw new RecordNotFoundException("Record Not Found into Database");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(department));
    }

    @DeleteMapping("/department/{id}")
    @ApiOperation(value = "delete department by id", notes = "delete department DB based on empId", response = Department.class)
    public ResponseEntity<Department> deleteDepartmentById(@PathVariable("id") int id) {
        Department department = departmentService.deleteEmployeeById(id);
        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(department));
    }


}
