package com.cv.gradebook.service;

import com.cv.gradebook.domain.Subject;

import java.util.List;

public interface SubjectService {
    Subject create(Subject subject);

    Subject findById(Long subjectId);

    Subject update(Subject newSubject, Long existingId);

    void delete(Long subjectId);

    List<Subject> findAll();
}
