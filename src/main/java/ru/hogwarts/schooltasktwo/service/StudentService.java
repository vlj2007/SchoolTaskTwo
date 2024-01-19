package ru.hogwarts.schooltasktwo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.schooltasktwo.exception.BadRequestException;
import ru.hogwarts.schooltasktwo.model.Student;
import ru.hogwarts.schooltasktwo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createdStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new BadRequestException("Отсутствует id"));
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents(Student student) {
        studentRepository.deleteAll();
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }



//    public Collection<Student> findStudentByAge2(int age){
//        return studentRepository.findStudentByAge2(age);
//    }
//
//    public Collection<Student> findAllByAgeContains(int age){
//        return studentRepository.findAllByAgeContains(age);
//    }

}
