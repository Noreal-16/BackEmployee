package com.example.employee.Models.Dto;

import com.example.employee.Models.Address;
import com.example.employee.Models.Departament;
import com.example.employee.Models.Mission;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class EmployeeDto {
    private long id;

    private String identifier;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Departament departament;
    private List<Mission> missions;
}
