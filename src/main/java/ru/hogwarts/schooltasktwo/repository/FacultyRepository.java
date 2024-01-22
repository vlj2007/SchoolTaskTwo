package ru.hogwarts.schooltasktwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schooltasktwo.model.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    public List<Faculty> findByColor (String color);

    Faculty findFacultyByNameIgnoreCase(String name);
    Faculty findFacultyByColorIgnoreCase(String color);

}
