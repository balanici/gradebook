package com.cv.gradebook.service.impl;

import com.cv.gradebook.domain.Subject;
import com.cv.gradebook.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public Subject create(Subject subject) {
        return null;
    }

    @Override
    public Subject findById(Long subjectId) {
        return null;
    }

    @Override
    public Subject update(Subject newSubject, Long existingId) {
        return null;
    }

    @Override
    public void delete(Long subjectId) {

    }

    @Override
    public List<Subject> findAll() {
        return null;
    }
}
