package ru.hogwarts.schooltasktwo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.schooltasktwo.model.Faculty;
import ru.hogwarts.schooltasktwo.repository.FacultyRepository;
import ru.hogwarts.schooltasktwo.exception.BadRequestException;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new BadRequestException("Отсутствует id"));
    }

    public void deleteAllFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public void deleteAllFaculty(Faculty faculty) {
        facultyRepository.deleteAll();

    }

    public List<Faculty> showAllFaculty() {
        return facultyRepository.findAll();
    }

    public List<Faculty> findByName(String name) {
        return facultyRepository.findByName(name);
    }

    public List<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
