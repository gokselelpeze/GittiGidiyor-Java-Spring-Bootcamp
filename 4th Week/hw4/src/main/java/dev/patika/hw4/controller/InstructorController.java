package dev.patika.hw4.controller;

import dev.patika.hw4.dto.PermanentInstructorDTO;
import dev.patika.hw4.dto.VisitingResearcherDTO;
import dev.patika.hw4.model.Instructor;
import dev.patika.hw4.model.PermanentInstructor;
import dev.patika.hw4.model.VisitingResearcher;
import dev.patika.hw4.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<?> findAllInstructors() {
        List<Instructor> result = instructorService.findAllInstructors();

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<?> findInstructorById(@PathVariable @Valid int instructorId) {
        Optional<Instructor> resultOptional = instructorService.findInstructorById(instructorId);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/instructors/permanentInstructor")
    public ResponseEntity<?> savePermanentInstructor(@RequestBody @Valid PermanentInstructorDTO permanentInstructorDTO) {
        Optional<Instructor> resultOptional = instructorService.savePermanentInstructor(permanentInstructorDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/instructors/visitingResearcher")
    public ResponseEntity<?> saveVisitingResearcher(@RequestBody @Valid VisitingResearcherDTO visitingResearcherDTO) {
        Optional<Instructor> resultOptional = instructorService.saveVisitingResearcher(visitingResearcherDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/instructors/permanentInstructor")
    public ResponseEntity<?> updatePermanentInstructor(@RequestBody @Valid PermanentInstructorDTO permanentInstructorDTO) {
        if (instructorService.existsById(permanentInstructorDTO.getId())) {
            return new ResponseEntity<>(instructorService.savePermanentInstructor(permanentInstructorDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + permanentInstructorDTO.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/instructors/visitingResearcher")
    public ResponseEntity<?> updateVisitingResearcher(@RequestBody @Valid VisitingResearcherDTO visitingResearcherDTO) {
        if (instructorService.existsById(visitingResearcherDTO.getId())) {
            return new ResponseEntity<>(instructorService.saveVisitingResearcher(visitingResearcherDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + visitingResearcherDTO.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/instructors/permanentInstructor")
    public ResponseEntity<String> deletePermanentInstructor(@RequestBody @Valid PermanentInstructor instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            instructorService.deletePermanentInstructor(instructor);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/instructors/visitingResearcher")
    public ResponseEntity<String> deleteVisitingResearcher(@RequestBody @Valid VisitingResearcher instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            instructorService.deleteVisitingResearcher(instructor);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable int instructorId) {
        if (instructorService.existsById(instructorId)) {
            instructorService.deleteInstructorById(instructorId);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/instructors/byName")
    public ResponseEntity<?> findInstructorsByFirstNameAndLastName(@RequestParam String name) {
        return new ResponseEntity<>(instructorService.findInstructorsByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/instructors/byName")
    public ResponseEntity<String> deleteInstructorByFirstNameAndLastName(@RequestParam String name) {
        if (instructorService.findInstructorsByName(name).isEmpty()) {
            return new ResponseEntity<>("Instructor with name: " + name + " not found.", HttpStatus.BAD_REQUEST);
        } else {
            instructorService.deleteInstructorByName(name);
            return new ResponseEntity<>("Instructor with name: " + name + " deleted.", HttpStatus.OK);
        }
    }

    @GetMapping("/instructors/permanentInstructor/top3")
    public ResponseEntity<?> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc() {
        return new ResponseEntity<>(instructorService.findFirst3PermanentInstructorsByOrderByFixedSalaryDesc(), HttpStatus.OK);
    }

    @GetMapping("/instructors/permanentInstructor/last3")
    public ResponseEntity<?> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc() {
        return new ResponseEntity<>(instructorService.findFirst3PermanentInstructorsByOrderByFixedSalaryAsc(), HttpStatus.OK);
    }

    @GetMapping("/instructors/visitingResearcher/top3")
    public ResponseEntity<?> findFirst3VisitingResearchersByOrderByHourlySalaryDesc() {
        return new ResponseEntity<>(instructorService.findFirst3VisitingResearchersByOrderByHourlySalaryDesc(), HttpStatus.OK);
    }

    @GetMapping("/instructors/visitingResearcher/last3")
    public ResponseEntity<?> findFirst3VisitingResearchersByOrderByHourlySalaryAsc() {
        return new ResponseEntity<>(instructorService.findFirst3VisitingResearchersByOrderByHourlySalaryAsc(), HttpStatus.OK);
    }

}
