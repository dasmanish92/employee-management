package org.employee.management.repository;

import org.employee.management.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpRepository extends CrudRepository<Employee, Integer> {

    public Employee save(Employee employee);

    public Employee findById(int id);

    public List<Employee> findAll();

    public void delete(Employee employee);

    //public Employee save(Employee employee);

    public Employee deleteById(int id);

   // public Employee
}
