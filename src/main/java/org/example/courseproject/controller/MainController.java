package org.example.courseproject.controller;


import org.example.courseproject.domain.Student;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/students")
public class MainController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/all")
    public String all(Model model) {
        Iterable<Student> students = repository.findAll();
        model.addAttribute("students", students);
        return "all";
    }

    @PostMapping("/add")
    public String add(ServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        repository.save(new Student(firstName, lastName, birthDate));
        return "redirect:/students/all";
    }



}
