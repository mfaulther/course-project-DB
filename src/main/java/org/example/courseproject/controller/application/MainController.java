package org.example.courseproject.controller.application;


import org.example.courseproject.domain.Group;
import org.example.courseproject.domain.Student;
import org.example.courseproject.repository.GroupRepository;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class MainController {

    @Autowired
    StudentRepository repository;

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/all")
    public String all(Model model) {
        Iterable<Student> students = repository.findAll();
        model.addAttribute("students", students);
        return "all";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        List<Group> groups = new ArrayList<>();
        groupRepository.findAll().forEach(groups::add);
        model.addAttribute("groups", groups);
        return "add_student";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/students/all";
    }

    @GetMapping("/{id}")
    public String student(@PathVariable long id, Model model) {
        Student student = repository.findById(id).get();
        model.addAttribute("student", student);
        return "student";
    }

}
