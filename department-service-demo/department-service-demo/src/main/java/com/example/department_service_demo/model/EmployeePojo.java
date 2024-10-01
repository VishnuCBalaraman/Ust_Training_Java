package com.example.department_service_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeePojo {
    private long empId;
    private String empName;
    private long empDeptId;
}
