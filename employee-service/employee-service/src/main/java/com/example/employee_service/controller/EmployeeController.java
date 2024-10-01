package com.example.employee_service.controller;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;

    public static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }

    @GetMapping("/employees/departments/{did}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable long did){
        return empRepo.findByEmpDeptId(did);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmp) {
        return empRepo.saveAndFlush(newEmp);
    }
}
