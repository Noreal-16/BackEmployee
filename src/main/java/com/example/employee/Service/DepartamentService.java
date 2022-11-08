package com.example.employee.Service;


import com.example.employee.Models.Dto.DepartamentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentService {
    DepartamentDto getById(long id);

    List<DepartamentDto> getAllDepartament();

    DepartamentDto createDepartament(DepartamentDto departamentDto);

    DepartamentDto updateDepartament(long id, DepartamentDto departamentDto);

    Long deleteDepartament(long id);
}
