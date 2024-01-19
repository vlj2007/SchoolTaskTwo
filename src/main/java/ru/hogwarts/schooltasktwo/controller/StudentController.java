package ru.hogwarts.schooltasktwo.controller;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schooltasktwo.model.Student;
import ru.hogwarts.schooltasktwo.service.StudentService;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping //POST localhost:8080/students/1 (для отправки данных на сервер, создаем студента)
    public Student createStudent(Student student) {
        return studentService.createdStudent(student);
    }

    @GetMapping("{id}") //http://localhost:8080/students/4 (для получения данных с сервера, выводит студента по id)
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping //PUT localhost:8080/students/ (для редактирования данных студента)
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/students/2 (для удаления данных студента)
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/find") //http://localhost:8080/students/find
    public Collection<Student> getStudents() {
        return studentService.getAllStudent();
    }

    @DeleteMapping() //DELETE http://localhost:8080/students/1
    public ResponseEntity<Void> deleteAllStudents(Student student) {
        studentService.deleteAllStudents(student);
        return ResponseEntity.ok().build();
    }



//    @GetMapping(path = "/find") // http://localhost:8080/students/find
//    public ResponseEntity findStudentByAge(@RequestParam String name, @RequestParam int age) {
//        if (name !=null && !name.isBlank()){
//            return ResponseEntity.ok(studentService.findStudentByName(name));
//        }
//        if (age != 0){
//            return ResponseEntity.ok(studentService.findStudentByAge(age));
//        }
//        return ResponseEntity.ok(studentService.findAllByAgeContains(age));
//    }

}
