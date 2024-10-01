package com.example.department_service_demo.controller;

import com.example.department_service_demo.model.DepartmentPojo;
import com.example.department_service_demo.model.EmployeePojo;
import com.example.department_service_demo.service.DepartmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

//https://code-with-me.global.jetbrains.com/JhbiuhdawMDg2GTNSUd3KA#p=IC&fp=8FA4142F2C65169B5C54740D93197D55A475357AA52E8CB10E5BC72F197C81E8&newUi=true

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    public static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/departments")
    public List<DepartmentPojo> getAllDepartments(){
        LOG.info("in getAllDepartments()");
        List<DepartmentPojo> departments = deptService.getAllDepartments();
        RestClient restClient = RestClient.create();

        for (DepartmentPojo dept : departments) {
            List<EmployeePojo> allEmps = restClient
                    .get()
                    .uri("http://localhost:8082/api/employees/departments/" + dept.getDeptId())
                    .retrieve()
                    .body(List.class);
            dept.setAllEmployees(allEmps);
        }

        return departments;

    }

    @GetMapping("/departments/{did}")
    @CircuitBreaker(name="ciremp", fallbackMethod="empFallBack")
    public DepartmentPojo getDepartmentById(@PathVariable("did") long deptId){
        LOG.info("in getDepartmentById()");
        DepartmentPojo deptPojo = deptService.getDepartmentById(deptId);
        RestClient restClient = RestClient.create();
        List<EmployeePojo> allEmps = restClient
                .get()
                .uri("http://localhost:8082/api/employees/departments/" + deptId)
                .retrieve()
                .body(List.class);
        deptPojo.setAllEmployees(allEmps);
        return deptPojo;
    }

    public DepartmentPojo empFallBack(){
        return new DepartmentPojo(0,"fallback",null);
    }

    @PostMapping("/departments")
    public DepartmentPojo addDepartment(@RequestBody DepartmentPojo newDep){
        LOG.info("in addDepartment()");
        return deptService.addDepartment(newDep);
    }

    @PutMapping("/departments")
    public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo upDep){
        LOG.info("in updateDepartment()");
        return deptService.updateDepartment(upDep);
    }

    @DeleteMapping("/departments/{did}")
    public void deleteDepartment(@PathVariable("did") long deptId){
        LOG.info("in deleteDepartment()");
        deptService.deleteDepartment(deptId);
    }


}
