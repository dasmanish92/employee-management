package org.employee.management.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.employee.management.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", length = 11)
    private int empId;

    //@Column(name = "emp_first_name", length = 14)
    private String firstName;

    //@Column(name = "emp_second_name", length = 16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    //@Column(name = "emp_gender")
    private Gender genderEnum;

    @Temporal(TemporalType.DATE)
    //@Column(name = "emp_birth_date")
    private Date birthDate;

   //@Column(name = "emp_hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    ///@JoinColumn(name = "dept_id")
    @JoinTable(
            name = "dept_emp",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id"))
    @JsonManagedReference
    private Department department;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "salary_id")
    @JoinTable(
            name = "salary_emp",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "salary_id"))
    @JsonManagedReference
    private Salary salary;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "title")
    @JsonManagedReference
    private Title title;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
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
