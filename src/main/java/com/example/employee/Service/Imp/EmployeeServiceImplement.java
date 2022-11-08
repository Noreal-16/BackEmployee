package com.example.employee.Service.Imp;

import com.example.employee.Models.Dto.EmployeeDto;
import com.example.employee.Models.Employee;
import com.example.employee.Reposiroty.EmployeeRepository;
import com.example.employee.Service.EmployeeService;
import com.example.employee.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto findById(long id) {
        Employee employee = getByIdEmployee(id);
        return convertEntityToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return this.employeeRepository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = convertDtotoEmtity(employeeDto);
        return convertEntityToDto(this.employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = getByIdEmployee(id);
        employee.setAddress(employeeDto.getAddress());
        employee.setEmail(employeeDto.getEmail());
        employee.setIdentifier(employeeDto.getIdentifier());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartament(employeeDto.getDepartament());
        return convertEntityToDto(this.employeeRepository.save(employee));
    }

    @Override
    public Long deleteEMployee(long id) {
        getByIdEmployee(id);
        this.employeeRepository.deleteById(id);
        return id;
    }

    private EmployeeDto convertEntityToDto(Employee employee) {
        return Mapper.modelMapper().map(employee, EmployeeDto.class);
    }

    private Employee convertDtotoEmtity(EmployeeDto employeeDto) {
        return Mapper.modelMapper().map(employeeDto, Employee.class);
    }

    private Employee getByIdEmployee(long id) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Employee con el id " + id);
        }
        return employeeOptional.get();
    }
}
