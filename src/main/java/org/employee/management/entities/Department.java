package org.employee.management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_no", length = 04)
    private int depNo;

    @Column(name = "dept_name")
    private String dept_name;

    @OneToMany
    //@JsonBackReference
    private List<Employee> employee;


    public int getDepNo() {
        return depNo;
    }

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }


    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    /*public DepartmentManager getManager() {
        return manager;
    }

    public void setManager(DepartmentManager manager) {
        this.manager = manager;
    }*/
}
