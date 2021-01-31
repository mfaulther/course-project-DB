package org.example.courseproject.controller.api;


import org.example.courseproject.domain.Faculty;
import org.example.courseproject.domain.Group;
import org.example.courseproject.dto.GroupDTO;
import org.example.courseproject.repository.FacultyRepository;
import org.example.courseproject.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {


    GroupRepository groupRepo;
    FacultyRepository facultyRepo;

    @Autowired
    public GroupController(GroupRepository groupRepo, FacultyRepository facultyRepo) {
        this.groupRepo = groupRepo;
        this.facultyRepo = facultyRepo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody GroupDTO groupDTO) {

        String title = groupDTO.getTitle();
        String levelOfEducation = groupDTO.getLevel();
        String direction = groupDTO.getDirection();
        long facultyId = groupDTO.getFacultyId();
        Faculty faculty = facultyRepo.findById(facultyId).get();
        Group newGroup = new Group(title, levelOfEducation, direction, faculty);
        groupRepo.save(newGroup);

        return "created !";
    }

    @GetMapping
    public List<GroupDTO> getAllGroups() {

        List<GroupDTO> groups = new ArrayList<>();

        groupRepo.findAll().forEach( g -> {
            long id = g.getId();
            String title = g.getTitle();
            String level = g.getLevelOfEducation();
            String direction = g.getDirection();
            long facultyId = g.getFaculty().getId();
            groups.add(new GroupDTO(id, title, level, direction, facultyId));
        });

        return groups;
    }

}
