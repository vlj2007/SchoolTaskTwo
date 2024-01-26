package ru.hogwarts.schooltasktwo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.schooltasktwo.model.Faculty;
import ru.hogwarts.schooltasktwo.model.Student;
import ru.hogwarts.schooltasktwo.repository.FacultyRepository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {

    @InjectMocks
    FacultyService facultyService;

    @Mock
    FacultyRepository facultyRepository;

    Faculty faculty1 = new Faculty("red", "Gryffindor");
    Faculty faculty2 = new Faculty("green", "Slythering");
    Faculty faculty3 = new Faculty("yellow", "Hufflepuff");
    Faculty faculty4 = new Faculty("bluee", "Revenclaw");
    Faculty faculty5 = new Faculty("green", "Perfect");

    List<Faculty> facultyList;


    @BeforeEach
    void setUp() {
        faculty1.setId(1L);
        faculty2.setId(2L);
        faculty3.setId(3L);
        faculty4.setId(4L);
        faculty5.setId(5L);
        facultyList = new ArrayList<>(List.of(faculty1, faculty2, faculty3, faculty4, faculty5));
    }

    @Test
    void shouldAddOrUpdateFacultySuccessful() {
        Mockito.when(facultyRepository.save(faculty1)).thenReturn(faculty1);
        facultyService.createFaculty(faculty1);
        Mockito.verify(facultyRepository, Mockito.times(1)).save(faculty1);
        assertEquals(faculty1, facultyService.createFaculty(faculty1));
    }

    @Test
    void findStudentById() {
        Long ID = 2L;
        Mockito.when(facultyRepository.findById(ID)).thenReturn(Optional.of(faculty2));
        assertEquals(faculty2, facultyService.findFaculty(faculty2.getId()));
        Mockito.verify(facultyRepository, Mockito.times(1)).findById(ID);
    }

    @Test
    void shouldAThrowNotException() {
        Long id = 7L;
        Mockito.when(facultyRepository.findById(id)).thenThrow(HttpClientErrorException.NotFound.class);
        assertThrows((HttpClientErrorException.NotFound.class), () -> facultyService.findFaculty(id));
    }

    @Test
    void shouldSuccessfulDeleteFaculty() {
        Long id = 4L;
        Mockito.doNothing().when(facultyRepository).deleteById(id);
        facultyService.deleteAllFaculty(id);
        Mockito.verify(facultyRepository, Mockito.times(1)).deleteById(id);
    }

}