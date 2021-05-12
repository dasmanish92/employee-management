package org.employee.management;

import org.employee.management.entities.Department;
import org.employee.management.entities.Employee;
import org.employee.management.entities.Salary;
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

    }

}
