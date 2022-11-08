package com.example.employee.Controller;

import com.example.employee.Models.Dto.DepartamentDto;
import com.example.employee.Service.DepartamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/departament", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentController {
    private final DepartamentService departamentService;

    @GetMapping
    public ResponseEntity<List<DepartamentDto>> getAllDepartament() {
        return ResponseEntity.ok(this.departamentService.getAllDepartament());
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartamentDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.departamentService.getById(id));
    }

    @PostMapping
    public  ResponseEntity<DepartamentDto> createDepartament(@RequestBody DepartamentDto departamentDto){
        return new ResponseEntity<>(this.departamentService.createDepartament(departamentDto), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public  ResponseEntity<DepartamentDto> updateDepartament(@PathVariable long id, @RequestBody DepartamentDto departamentDto){
        return new ResponseEntity<>(this.departamentService.updateDepartament(id, departamentDto), HttpStatus.CREATED);
    }
    @DeleteMapping ("{id}")
    public  ResponseEntity<Long> deleteDepartament(@PathVariable long id){
        return ResponseEntity.ok(this.departamentService.deleteDepartament(id));
    }
}
