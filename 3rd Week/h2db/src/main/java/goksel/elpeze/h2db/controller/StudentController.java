package goksel.elpeze.h2db.controller;

import goksel.elpeze.h2db.entity.Student;
import goksel.elpeze.h2db.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student students) {
        return studentService.save(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/students/genders")
    public ResponseEntity<Student> findGenders() {
        return new ResponseEntity<>((Student) studentService.findStudentsGendersAndCounts(), HttpStatus.OK);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student students) {
        return studentService.update(students);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id) {
        studentService.deleteById(id);
        return "Student Deleted";
    }

}
