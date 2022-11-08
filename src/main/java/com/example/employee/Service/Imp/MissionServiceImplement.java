package com.example.employee.Service.Imp;

import com.example.employee.Models.Dto.MissionDto;
import com.example.employee.Models.Mission;
import com.example.employee.Reposiroty.MissionRepository;
import com.example.employee.Service.MissionService;
import com.example.employee.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MissionServiceImplement implements MissionService {

    private final MissionRepository missionRepository;

    @Override
    public MissionDto findById(long id) {
        Mission mission = getByIdMission(id);
        return convertEntityToDto(mission);
    }

    @Override
    public List<MissionDto> getAllMission() {
        return this.missionRepository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public MissionDto createMission(MissionDto missionDto) {
        Mission mission = convertDtoToEntity(missionDto);
        return convertEntityToDto(this.missionRepository.save(mission));
    }

    @Override
    public MissionDto updateMission(long id, MissionDto missionDto) {
        Mission mission = getByIdMission(id);
        mission.setDuration(missionDto.getDuration());
        mission.setName(missionDto.getName());
        mission.setEmployees(missionDto.getEmployees());
        return convertEntityToDto(this.missionRepository.save(mission));
    }

    @Override
    public Long deleteMission(long id) {
        getByIdMission(id);
        this.missionRepository.deleteById(id);
        return id ;
    }

    private MissionDto convertEntityToDto(Mission mission) {
        return Mapper.modelMapper().map(mission, MissionDto.class);
    }

    private Mission convertDtoToEntity(MissionDto missionDto) {
        return Mapper.modelMapper().map(missionDto, Mission.class);
    }

    private Mission getByIdMission(long id) {
        Optional<Mission> missionOptional = this.missionRepository.findById(id);
        if (missionOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Mission con el id " + id);
        }
        return missionOptional.get();
    }
}
