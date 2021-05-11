package org.employee.management.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.employee.management.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", length = 11)
    private int empId;

    @Column(name = "emp_first_name", length = 14)
    private String firstName;

    @Column(name = "emp_second_name", length = 16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "emp_gender")
    private Gender genderEnum;

    @Column(name = "emp_birth_date")
    private LocalDate birthDate;

    @Column(name = "emp_hire_date")
    private LocalDate hireDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    @JsonManagedReference
    private Department department;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    @JsonManagedReference
    private Salary salary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(Gender genderEnum) {
        this.genderEnum = genderEnum;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
