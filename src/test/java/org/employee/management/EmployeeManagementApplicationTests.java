package org.employee.management;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
import org.employee.management.entities.Title;
import org.employee.management.enums.Gender;
import org.employee.management.repository.EmpRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class EmployeeManagementApplicationTests {

    @Mock
    private EmpRepository empRepository;

   /* @Test
    public void contextLoads() {
    }*/

    @Test
    @DisplayName("new employee instance should be created")
    public void createEmployee() {
        Employee employee = populateEmployeeData();
        empRepository.save(employee);
        Mockito.verify(empRepository, Mockito.times(1)).save(ArgumentMatchers.any(Employee.class));
    }

    @Test
    @DisplayName("employee should be found by id")
    public void findByIdTest() {
        Employee employee = populateEmployeeData();
        Mockito.when(empRepository.findById(1)).thenReturn(employee);
        Employee actualEmployee = empRepository.findById(1);
        assertThat(actualEmployee.getEmpId()).isEqualTo(employee.getEmpId());
    }
    @Test
    @DisplayName("employee should be found by lastName, Gender and DOB")
    public void findAllByLastNameAndGenderEnumAndBirthDateTest() {
        Employee employee = populateEmployeeData();
        Mockito.when(Gender.MALE.name()).thenReturn("MALE");
        Mockito.when(employee.getBirthDate()).thenReturn(new Date("1990-11-04"));
        Mockito.when(empRepository.findAllByLastNameAndGenderEnumAndBirthDate("kumar", Gender.MALE, new Date("1990-11-04"))).thenReturn((List<Employee>) employee);
        List<Employee> actualEmployee = empRepository.findAllByLastNameAndGenderEnumAndBirthDate("kumar", Gender.MALE, new Date("1990-11-04"));
        Employee emp = actualEmployee.get(0);
        assertThat(emp.getEmpId()).isEqualTo(employee.getEmpId());
        assertThat(emp.getLastName()).isEqualTo(employee.getLastName());
        assertThat(emp.getGenderEnum()).isEqualTo(employee.getGenderEnum());
        assertThat(emp.getBirthDate()).isEqualTo(employee.getBirthDate());
    }





    public Employee populateEmployeeData(){
        Employee employee = new Employee();
        Department department = new Department();
        Salary salary = new Salary();
        Title title = new Title();
        List<Employee>employeeList = new ArrayList<>();

        //employee data
        employee.setEmpId(1);
        employee.setFirstName("manish");
        employee.setLastName("kumar");
        employee.setGenderEnum(Gender.MALE);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setBirthDate(new Date(1990, 11, 04));
        employee.setHireDate(new Date(2018, 10, 29));

        //department data
        department.setDept_name("HR");
        department.setEmployee(employeeList);

        //salary data
        salary.setSalary(50000);
        salary.setFromDate(new Date(2021, 1, 01));
        salary.setToDate(new Date(2021, 3, 31));
        salary.setEmployee(employeeList);

        title.setTitle("Software Engineer");
        title.setEmployee(employeeList);

        return employee;
    }



}
