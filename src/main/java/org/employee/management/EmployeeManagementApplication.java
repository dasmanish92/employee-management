package org.employee.management;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
import org.employee.management.entities.Title;
import org.employee.management.enums.Gender;
import org.employee.management.repository.EmpRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
@EnableSwagger2
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);
        EmpRepository repository = context.getBean(EmpRepository.class);
        Employee employee = repository.save(populateEmployeeData());
        System.out.println(employee);

    }

    public static Employee populateEmployeeData() {
        Employee employee = new Employee();
        Department department = new Department();
        Salary salary = new Salary();
        Title title = new Title();

        //employee data
        employee.setEmpId(1);
        employee.setFirstName("manish");
        employee.setLastName("kumar");
        employee.setGenderEnum(Gender.MALE);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setBirthDate(new Date(1990, 11, 04));
        employee.setHireDate(new Date(2018, 10, 29));
        employee.setTitle(title);

        //department data
        List<Employee>employeeList = new ArrayList<>();
        employeeList.add(employee);
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
