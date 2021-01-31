package org.example.courseproject.repository;

import org.example.courseproject.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}
