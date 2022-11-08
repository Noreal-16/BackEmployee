package com.example.employee.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mission", nullable = false, unique = true)
    private long id;

    private String name;
    private String duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;
}
