package org.example.courseproject.repository;

import org.example.courseproject.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
