package com.cv.gradebook.service;

import com.cv.gradebook.domain.Grade;

import java.util.List;

public interface GradeService {
    Grade create(Grade grade);

    Grade findById(Long gradeId);

    Grade update(Grade newGrade, Long existingId);

    void delete(Long gradeId);

    List<Grade> findAll();
}
