package org.employee.management.repository;

import org.employee.management.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmpRepository extends CrudRepository<Employee, Integer> {

    public Employee save(Employee employee);

    public Employee findById(int id);

    public List<Employee> findAll();

    public void delete(Employee employee);

    public Employee deleteById(int id);

   /*@Query("select e from employee e WHERE e.firstName=:fName AND e.lastName=:lName")
   public List<Employee> findAllByLastName(@Param("fName") String firstName, @Param("lName") String lastName);*/
}
