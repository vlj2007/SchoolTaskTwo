package ru.hogwarts.schooltasktwo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schooltasktwo.model.Faculty;
import ru.hogwarts.schooltasktwo.service.FacultyService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping //POST localhost:8080/faculty/1
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty newFaculty = facultyService.createFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(newFaculty);
    }

    @PutMapping //PUT localhost:8080/faculties/1
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty editFaculty = facultyService.createFaculty(faculty.getId(), faculty);
        if (editFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editFaculty);
    }

    @GetMapping("{id}") //GET http://localhost:8080/faculties/1
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyService.findFaculty(id));
    }

    @GetMapping(path = "/find") // http://localhost:8080/faculty/find
    public Collection<Faculty> getFaculty() {
        return facultyService.showAllFaculty();
    }

    @GetMapping(path = "{name}") // http://localhost:8080/faculty/find
    public ResponseEntity <?> findByName(@RequestParam String name) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(facultyService.findByName(name));
        }
        return ResponseEntity.ok(facultyService.showAllFaculty());
    }

    @GetMapping(path = "{color}")
    public ResponseEntity<?> findFaculties(@RequestParam String color) {
        if (color != null && !color.isBlank()) {
            ResponseEntity<List<Faculty>> ok = ResponseEntity.ok(facultyService.findByColor(color));
            return ok;
        }
        return ResponseEntity.ok(facultyService.showAllFaculty());
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/faculties/1
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping() //DELETE http://localhost:8080/faculty/1
    public ResponseEntity<Void> deleteAllFaculty(Faculty faculty) {
        facultyService.deleteAllFaculty(faculty);
        return ResponseEntity.ok().build();
    }

}
