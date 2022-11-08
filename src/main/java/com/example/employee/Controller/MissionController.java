package com.example.employee.Controller;

import com.example.employee.Models.Dto.MissionDto;
import com.example.employee.Service.MissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/mission", produces = MediaType.APPLICATION_JSON_VALUE)
public class MissionController {
    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<List<MissionDto>> getAll() {
        return ResponseEntity.ok(this.missionService.getAllMission());
    }

    @GetMapping("{id}")
    public ResponseEntity<MissionDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.missionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MissionDto> createMission(@RequestBody MissionDto missionDto) {
        return new ResponseEntity<>(this.missionService.createMission(missionDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MissionDto> updateMission(@PathVariable long id, @RequestBody MissionDto missionDto ) {
        return new ResponseEntity<>(this.missionService.updateMission(id,missionDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteMission(@PathVariable long id) {
        return ResponseEntity.ok(this.missionService.deleteMission(id));
    }
}
