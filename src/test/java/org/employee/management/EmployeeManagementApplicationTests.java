/*
package org.employee.management;

import com.sun.istack.NotNull;
import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
import org.employee.management.enums.Gender;
import org.employee.management.repository.EmpRepository;
//import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class EmployeeManagementApplicationTests {

    @Autowired
    EmpRepository empRepository;

    @Test
    public void contextLoads() {
    }

    @BeforeClass
    public void setEmpRepository () {
        this.empRepository = empRepository;
    }


    @Test
    public void TestCreate() {
        Employee employee = populateEmployeeData();
        empRepository.save(employee);
        assertNotNull(empRepository.findById(2));



    }

    public Employee populateEmployeeData(){
        Employee employee = new Employee();
        Department department = new Department();
        Salary salary = new Salary();

        //employee data
        employee.setEmpId(2);
        employee.setFirstName("manish");
        employee.setLastName("kumar");
        employee.setGenderEnum(Gender.MALE);
        employee.setDepartment(department);
        employee.setSalary(salary);
        //employee.setBirthDate(LocalDate.of(1990, 11, 04));
        //employee.setHireDate(LocalDate.of(2018, 10, 29));

        //department data
        department.setDept_name("HR");
        department.setEmployee(employee);

        //salary data
        salary.setSalary(50000);
        //salary.setFromDate(LocalDate.of(2021, 1, 01));
        //salary.setToDate(LocalDate.of(2021, 3, 31));
        //salary.setEmployee(employee);

        return employee;
    }



}
*/
