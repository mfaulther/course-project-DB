package org.example.courseproject.controller;


import org.example.courseproject.domain.Student;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/students")
    public Iterable<Student> students() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentRepository.findById(id).get();
    }


}
