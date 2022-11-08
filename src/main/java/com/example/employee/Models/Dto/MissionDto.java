package com.example.employee.Models.Dto;

import com.example.employee.Models.Employee;
import lombok.Data;

import java.util.List;

@Data
public class MissionDto {
    private long id;
    private String name;
    private String duration;
    private List<Employee> employees;
}
