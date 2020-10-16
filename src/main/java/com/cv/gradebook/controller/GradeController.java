package com.cv.gradebook.controller;

import com.cv.gradebook.domain.Grade;
import com.cv.gradebook.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        return new ResponseEntity<>(gradeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeService.create(grade), HttpStatus.CREATED);
    }

    @GetMapping("/{gradeId}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long gradeId) {
        return new ResponseEntity<>(gradeService.findById(gradeId), HttpStatus.OK);
    }

    @PutMapping("/{gradeId}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long gradeId, @RequestBody Grade newGrade) {
        return new ResponseEntity<>(gradeService.update(newGrade, gradeId), HttpStatus.OK);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long gradeId) {
        gradeService.delete(gradeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
