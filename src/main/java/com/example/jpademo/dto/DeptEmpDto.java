package com.example.jpademo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeptEmpDto {

    private String empDept;
    private String empName;
    private String empEmail;
    private String empAddress;

    public DeptEmpDto(String empDept, String empName, String empEmail, String empAddress) {
        this.empDept = empDept;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }
}
