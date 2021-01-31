package org.example.courseproject.controller.api;

import org.example.courseproject.domain.Group;
import org.example.courseproject.domain.Student;
import org.example.courseproject.dto.StudentDTO;
import org.example.courseproject.repository.GroupRepository;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentRepository studentRepo;
    GroupRepository groupRepo;

    @Autowired
    public StudentController(StudentRepository studentRepo, GroupRepository groupRepo) {
        this.studentRepo = studentRepo;
        this.groupRepo = groupRepo;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCreatedResponse add(@RequestBody StudentDTO request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String birthDate = request.getBirthDate();
        long groupId = request.getGroupId();
        Group group = groupRepo.findById((long) groupId).get();
        Student student = new Student(firstName, lastName, birthDate, group);
        studentRepo.save(student);
        return new StudentCreatedResponse(student.getId(), "Successfully created !");
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> students = new ArrayList<>();
        studentRepo.findAll().forEach(s -> {

            String firstName = s.getFirstName();
            String lastName = s.getLastName();
            String birthDate = s.getBirthDate();
            long groupId = s.getGroup().getId();
            students.add(new StudentDTO(firstName, lastName, birthDate, groupId));
        });

        return students;
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(@PathVariable long id) {
        Student student = studentRepo.findById(id).get();
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getBirthDate(), student.getGroup().getId());
    }
}
