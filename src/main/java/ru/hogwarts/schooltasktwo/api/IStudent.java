package ru.hogwarts.schooltasktwo.api;

import ru.hogwarts.schooltasktwo.exception.BadRequestException;
import ru.hogwarts.schooltasktwo.model.Student;
import ru.hogwarts.schooltasktwo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

public interface IStudent {

    Student createdStudent(Student student);
    Student editStudent(Student student);
    Student findStudent(Long id);
    void deleteStudent(long id);
    void deleteAllStudents(Student student);
    void deleteAllStudents();
    Collection<Student> getAllStudent();
    Collection<Student> findByAgeBetween(Integer min, Integer max);
}
