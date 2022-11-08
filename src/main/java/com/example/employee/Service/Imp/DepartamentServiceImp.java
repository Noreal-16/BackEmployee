package com.example.employee.Service.Imp;

import com.example.employee.Models.Departament;
import com.example.employee.Models.Dto.DepartamentDto;
import com.example.employee.Reposiroty.DepartamentRepository;
import com.example.employee.Service.DepartamentService;
import com.example.employee.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartamentServiceImp implements DepartamentService {

    private final DepartamentRepository departamentRepository;

    @Override
    public DepartamentDto getById(long id) {
        return convertEntityToDto(getByIdDepartament(id));
    }

    @Override
    public List<DepartamentDto> getAllDepartament() {
        return this.departamentRepository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public DepartamentDto createDepartament(DepartamentDto departamentDto) {
        Departament departament =convertDtoToEntity(departamentDto);
        return convertEntityToDto(this.departamentRepository.save(departament));
    }

    @Override
    public DepartamentDto updateDepartament(long id, DepartamentDto departamentDto) {
        Departament departament = getByIdDepartament(id);
        departament.setName(departamentDto.getName());
        return convertEntityToDto(this.departamentRepository.save(departament));
    }

    @Override
    public Long deleteDepartament(long id) {
        getByIdDepartament(id);
        this.departamentRepository.deleteById(id);
        return id;
    }

    private DepartamentDto convertEntityToDto(Departament departament) {
        return Mapper.modelMapper().map(departament, DepartamentDto.class);
    }

    private Departament convertDtoToEntity(DepartamentDto departamentDto) {
        return Mapper.modelMapper().map(departamentDto, Departament.class);
    }

    private Departament getByIdDepartament(long id) {
        Optional<Departament> departamentOptional = this.departamentRepository.findById(id);
        if (departamentOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro departamentod con el id " + id);
        }
        return departamentOptional.get();
    }
}
