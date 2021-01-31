package org.example.courseproject.controller.api;

import org.example.courseproject.domain.Faculty;
import org.example.courseproject.repository.FacultyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    FacultyRepository facultyRepo;

    public FacultyController(FacultyRepository facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @PostMapping
    public String addFaculty(@RequestBody Faculty faculty) {
        facultyRepo.save(faculty);
        return "Created !";
    }

    @GetMapping
    public Iterable<Faculty> getAllFaculties() {
        return facultyRepo.findAll();
    }




}
