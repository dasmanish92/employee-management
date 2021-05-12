package org.employee.management.repository;

import org.employee.management.entities.Employee;
import org.employee.management.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmpRepository extends CrudRepository<Employee, Integer> {

    public Employee save(Employee employee);

    public Employee findById(int id);

    public List<Employee> findAll();

    public void delete(Employee employee);

    public Employee deleteById(int id);

    @Query("select e from Employee e WHERE e.firstName=:fName AND e.lastName=:lName")
    public List<Employee> findAllByFirstNameAndLastName(@Param("fName") String firstName, @Param("lName") String lastName);

    //@Query(value = "select * from employees WHERE last_name = :lastName AND gender_enum = :gender AND birth_date = :bDate", nativeQuery = true)
    //@Query("select e from Employee e WHERE e.lastName=:lName AND e.genderEnum=:gender AND e.birthDate=bDate")
    public List<Employee> findAllByLastNameAndGenderEnumAndBirthDate(@Param("lastName") String lastName, @Param("gender") Gender gender, @Param("bDate") Date bDate);

}
