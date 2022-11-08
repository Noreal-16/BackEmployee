package com.example.employee.Service;

import com.example.employee.Models.Dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDto findById(long id);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto createEmployee (EmployeeDto employeeDto);

    EmployeeDto updateEmployee(long id, EmployeeDto employeeDto);

    Long deleteEMployee(long id);
}
