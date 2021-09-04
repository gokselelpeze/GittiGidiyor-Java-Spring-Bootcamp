package goksel.elpeze.h2db.controller;

import goksel.elpeze.h2db.entity.Instructor;
import goksel.elpeze.h2db.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructors) {
        return instructorService.save(instructors);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructors) {
        return instructorService.update(instructors);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id) {
        instructorService.deleteById(id);
        return "Instructor Deleted";
    }

}
