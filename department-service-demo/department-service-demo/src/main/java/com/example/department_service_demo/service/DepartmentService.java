package com.example.department_service_demo.service;

import com.example.department_service_demo.entity.DepartmentEntity;

import java.util.List;

import com.example.department_service_demo.model.DepartmentPojo;



public interface DepartmentService {
    List<DepartmentPojo> getAllDepartments();
    DepartmentPojo getDepartmentById(long deptId);
    DepartmentPojo addDepartment(DepartmentPojo newDep);
    DepartmentPojo updateDepartment(DepartmentPojo upDep);
    void deleteDepartment(long deptId);

}
