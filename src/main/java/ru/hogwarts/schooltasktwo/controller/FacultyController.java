package ru.hogwarts.schooltasktwo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schooltasktwo.model.Faculty;
import ru.hogwarts.schooltasktwo.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }



    @PostMapping //POST localhost:8080/faculty/1
    public Faculty createFaculty(@PathVariable Faculty id) {
        return facultyService.createFaculty(id);
    }

    @GetMapping("{id}") //GET http://localhost:8080/faculties/1
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping //PUT localhost:8080/faculties/1
    public Faculty editFaculty(Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/faculties/1
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id) {
        facultyService.deleteAllFaculty(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping() //DELETE http://localhost:8080/faculty/1
    public ResponseEntity<Void> deleteAllFaculty(Faculty faculty) {
        facultyService.deleteAllFaculty(faculty);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/find") // http://localhost:8080/faculty/find
    public Collection<Faculty> getFaculty() {
        return facultyService.showAllFaculty();
    }

    @GetMapping(path = "/color")
    public ResponseEntity<Collection<Faculty>> findFacultyByColor(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }


//    @GetMapping(path = "/students")
//    public ResponseEntity<Collection<Faculty>> findStudentByFaculty(@RequestParam Long id) {
//         return ResponseEntity.ok(facultyService.findStudentByFaculty(id));
//    }

}
