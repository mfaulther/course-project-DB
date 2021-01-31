package org.example.courseproject;

import org.example.courseproject.domain.Group;
import org.example.courseproject.domain.Student;
import org.example.courseproject.repository.GroupRepository;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    StudentRepository repository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
