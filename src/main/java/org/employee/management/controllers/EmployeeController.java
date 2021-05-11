package org.employee.management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/home")
    @ResponseBody
    public String welcome() {
        return "Welcome to Employee Management System";
    }

}
