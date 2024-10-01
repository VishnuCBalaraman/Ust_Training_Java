package com.example.employee_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="employee_details")
public class Employee {

    @Id
    @Column(name="emp_id")
    private long empId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="dept_id")
    private long empDeptId;
}
