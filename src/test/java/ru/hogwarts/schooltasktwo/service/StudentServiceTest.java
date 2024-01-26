package ru.hogwarts.schooltasktwo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpClientErrorException;
import ru.hogwarts.schooltasktwo.model.Student;
import ru.hogwarts.schooltasktwo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    Student student1 = new Student("Lucius Malfoy", 20);
    Student student2 = new Student("Oliver Wood", 16);
    Student student3 = new Student("Cedric Diggory", 27);
    Student student4 = new Student("Moaning Myrtle", 19);

    List<Student> studentList;

    @BeforeEach
    void setUp() {
        student1.setId(1L);
        student2.setId(2L);
        student3.setId(3L);
        student3.setId(4L);
        studentList = new ArrayList<>(List.of(student1, student2, student3, student4));
    }

    @Test
    void shouldAddOrUpdateStudentSuccessful() {
        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
        studentService.createdStudent(student1);
        Mockito.verify(studentRepository, Mockito.times(1)).save(student1);
        assertEquals(student1, studentService.createdStudent(student1));
    }

    @Test
    void shouldSuccessfulDeleteStudent() {
        Long id = 4L;
        Mockito.doNothing().when(studentRepository).deleteById(id);
        studentService.deleteStudent(id);
        Mockito.verify(studentRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    void getAllStudentByAge() {
        List<Student> expectedStudentList = List.of(student2, student4);
        int age = 26;
        Mockito.when(studentRepository.findStudentByAge(age)).thenReturn(expectedStudentList);
        assertIterableEquals(expectedStudentList, studentService.findStudentByAge(age));
        Mockito.verify(studentRepository, Mockito.times(1)).findStudentByAge(age);
    }

    @Test
    void getAllStudents() {
        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        assertEquals(studentList, studentService.getAllStudent());

    }


}