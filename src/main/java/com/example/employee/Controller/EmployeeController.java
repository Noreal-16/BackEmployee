package com.example.employee.Controller;

import com.example.employee.Models.Dto.EmployeeDto;
import com.example.employee.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(this.employeeService.getAllEmployee());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(this.employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateById(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(this.employeeService.updateEmployee(id, employeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(this.employeeService.deleteEMployee(id));
    }

}
