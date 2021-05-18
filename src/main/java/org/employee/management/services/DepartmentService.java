package org.employee.management.services;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DeptRepository deptRepository;

    public Department saveDepartment(Department department) {
        Department savedDepartment = deptRepository.save(department);
        return  savedDepartment;
    }

    public Department findById(int id) {
        Department department = deptRepository.findById(id);
        return department;
    }

    public List<Department> findAllEmployees() {
        List<Department> departments = (List<Department>) deptRepository.findAll();
        return departments;
    }

    public Department deleteEmployee(Department department) {
        deptRepository.delete(department);
        return department;
    }

    public Department deleteEmployeeById(int id) {
        Department department = deptRepository.deleteById(id);
        return department;
    }


}
