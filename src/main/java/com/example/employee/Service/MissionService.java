package com.example.employee.Service;

import com.example.employee.Models.Dto.MissionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MissionService {
    MissionDto findById(long id);

    List<MissionDto> getAllMission();

    MissionDto createMission (MissionDto missionDto);

    MissionDto updateMission(long id, MissionDto missionDto);

    Long deleteMission(long id);
}
