package com.example.department_service_demo.model;

import java.util.ArrayList;
import java.util.List;


public class DepartmentPojo {
    private long deptId;
    private String deptName;
    private List<EmployeePojo> allEmployees;

    public DepartmentPojo() {
        this.allEmployees = null; // Initialize to null
    }


    public DepartmentPojo(long deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.allEmployees = new ArrayList<>(); // Initialize an empty list
    }
    public DepartmentPojo(long deptId, String deptName, List<EmployeePojo> allEmployees) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.allEmployees = allEmployees; // Initialize an empty list
    }

    public long getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<EmployeePojo> getAllEmployees() {
        return allEmployees;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setAllEmployees(List<EmployeePojo> allEmployees) {
        this.allEmployees = allEmployees;
    }


}
