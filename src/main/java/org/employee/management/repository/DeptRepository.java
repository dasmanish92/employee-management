package org.employee.management.repository;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeptRepository extends CrudRepository<Department, Integer> {

    public Department save(Department department);

    public Department findById(int id);

    public List<Department> findAll();

    public void delete(Department department);

    public Department deleteById(int id);
}
