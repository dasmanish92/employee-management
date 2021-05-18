package org.employee.management;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
import org.employee.management.entities.Title;
import org.employee.management.enums.Gender;
import org.employee.management.repository.EmpRepository;
import org.employee.management.services.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeManagementApplicationTests {

    @Mock
    private EmpRepository empRepository;

    @Mock
    private EmployeeService employeeService;

   /* @Test
    public void contextLoads() {
    }*/

  /* @BeforeEach
   public static void beforeTest() {
       Employee employee = populateEmployeeData();
       when(empRepository.save(anyObject())).thenReturn(employee);
       when(empRepository.findById(anyInt())).thenReturn(employee);
       when(Gender.MALE.name()).thenReturn("MALE");
       when(employee.getBirthDate()).thenReturn(new Date("1990-11-04"));
       when(empRepository.findAllByLastNameAndGenderEnumAndBirthDate("kumar", Gender.MALE, new Date("1990-11-04"))).thenReturn((List<Employee>) employee);

   }*/

    @Test
    @DisplayName("new employee instance should be created")
    public void createEmployee() {
        Employee employee = populateEmployeeData();
        when(empRepository.save(anyObject())).thenReturn(employee);
        employeeService.saveEmployee(employee);
        Mockito.verify(employeeService, Mockito.times(1)).saveEmployee(ArgumentMatchers.any(Employee.class));
    }

    @Test
    @DisplayName("employee should be found by id")
    public void findByIdTest() {
        Employee employee = populateEmployeeData();
        when(empRepository.findById(anyInt())).thenReturn(employee);
        when(employeeService.findById(anyInt())).thenReturn(employee);
        Employee actualEmployee = employeeService.findById(1);
        assertThat(actualEmployee.getEmpId()).isEqualTo(employee.getEmpId());
    }
    @Test
    @DisplayName("employee should be found by lastName, Gender and DOB")
    public void findAllByLastNameAndGenderEnumAndBirthDateTest() {
        Employee employee = populateEmployeeData();
        when(Gender.MALE.name()).thenReturn("MALE");
        when(employee.getBirthDate()).thenReturn(new Date("1990-11-04"));
        when(empRepository.findAllByLastNameAndGenderEnumAndBirthDate("kumar", Gender.MALE, new Date("1990-11-04"))).thenReturn((List<Employee>) employee);
        List<Employee> actualEmployee = employeeService.findAllByLastNameAndDobAndGender("kumar", Gender.MALE, new Date("1990-11-04"));
        Employee emp = actualEmployee.get(0);
        assertThat(emp.getEmpId()).isEqualTo(employee.getEmpId());
        assertThat(emp.getLastName()).isEqualTo(employee.getLastName());
        assertThat(emp.getGenderEnum()).isEqualTo(employee.getGenderEnum());
        assertThat(emp.getBirthDate()).isEqualTo(employee.getBirthDate());
    }





    public static Employee populateEmployeeData(){
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
