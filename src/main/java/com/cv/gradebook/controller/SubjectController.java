package com.cv.gradebook.controller;

import com.cv.gradebook.domain.Subject;
import com.cv.gradebook.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.create(subject), HttpStatus.CREATED);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable Long subjectId) {
        return new ResponseEntity<>(subjectService.findById(subjectId), HttpStatus.OK);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long subjectId, @RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.update(subject, subjectId), HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.delete(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
