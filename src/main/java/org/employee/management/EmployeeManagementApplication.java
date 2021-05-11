package org.employee.management;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
import org.employee.management.enums.Gender;
import org.employee.management.repository.EmpRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);

        EmpRepository empRepository = context.getBean(EmpRepository.class);
        System.out.println(empRepository.toString());

        Employee emp1 = empRepository.save(poplateEmpData());//poplateEmpData();
        System.out.println("saved entity : " + emp1);

    }

    private static Employee poplateEmpData() {
        Employee employee = new Employee();
        Department department = new Department();
        Salary salary = new Salary();

        //employee data
        employee.setFirstName("manish");
        employee.setLastName("kumar");
        employee.setGenderEnum(Gender.MALE);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setBirthDate(LocalDate.of(1990, 11, 04));
        employee.setHireDate(LocalDate.of(2018, 10, 29));

        //department data
        department.setDept_name("HR");
        department.setEmployee(employee);

        //salary data
        salary.setSalary(50000);
        salary.setFromDate(LocalDate.of(2021, 1, 01));
        salary.setToDate(LocalDate.of(2021, 3, 31));
        salary.setEmployee(employee);

        return employee;
    }

}
