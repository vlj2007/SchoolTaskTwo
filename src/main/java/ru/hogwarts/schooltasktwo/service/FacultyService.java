package ru.hogwarts.schooltasktwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.schooltasktwo.exception.FacultyListsIsEmptyException;
import ru.hogwarts.schooltasktwo.exception.FacultyNotFoundException;
import ru.hogwarts.schooltasktwo.model.Faculty;
import ru.hogwarts.schooltasktwo.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyService() {
    }

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Not found element"));
    }

    public Faculty deleteFaculty(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Not found element"));
        facultyRepository.delete(faculty);
        return faculty;


    }

    public void deleteAllFaculty(Faculty faculty) {
        facultyRepository.deleteAll();

    }

    public List<Faculty> showAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty findByName(String name) {
        return facultyRepository.findFacultyByNameIgnoreCase(name);
    }

    public List<Faculty> findByColor(String color) {
        List<Faculty> facultyList = facultyRepository.findByColor(color);
        if(facultyList.isEmpty()){
            throw new FacultyListsIsEmptyException("Lists is empty.");
        }
        return facultyList;
    }
}
