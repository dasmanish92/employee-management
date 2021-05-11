package org.employee.management.repository;

import org.employee.management.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Employee, Integer> {
}
