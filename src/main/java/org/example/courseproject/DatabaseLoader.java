package org.example.courseproject;

import org.example.courseproject.domain.Student;
import org.example.courseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Student("Vadim", "Khizhin", "13-11-1997"));
    }
}
