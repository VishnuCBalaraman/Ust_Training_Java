package com.example.department_service_demo.service;

import com.example.department_service_demo.entity.DepartmentEntity;
import com.example.department_service_demo.model.DepartmentPojo;
import com.example.department_service_demo.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
    public List<DepartmentPojo> getAllDepartments() {
        List<DepartmentEntity> allDeptEntity = departmentRepo.findAll();
        List<DepartmentPojo> allDeptPojo = new ArrayList<>();
        allDeptEntity.stream().forEach((eachDeptEntity) -> {
            DepartmentPojo deptPojo = new DepartmentPojo();
            BeanUtils.copyProperties(eachDeptEntity, deptPojo);
            allDeptPojo.add(deptPojo);
        });
        return allDeptPojo;
    }

    @Override
    public DepartmentPojo getDepartmentById(long deptId) {
        Optional<DepartmentEntity> fetchDepartmentEntity = departmentRepo.findById(deptId);
        DepartmentPojo deptPojo = null;
        if(fetchDepartmentEntity.isPresent()){
            deptPojo = new DepartmentPojo();
            BeanUtils.copyProperties(fetchDepartmentEntity.get(),deptPojo);
        }
        return deptPojo;
    }

    @Override
    public DepartmentPojo addDepartment(DepartmentPojo newDep) {
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(newDep,deptEntity);
        departmentRepo.saveAndFlush(deptEntity);
        return newDep;
    }

    @Override
    public DepartmentPojo updateDepartment(DepartmentPojo upDep) {
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(upDep,deptEntity);
        departmentRepo.saveAndFlush(deptEntity);
        return upDep;
    }

    @Override
    public void deleteDepartment(long deptId) {
        departmentRepo.deleteById(deptId);
    }
}
