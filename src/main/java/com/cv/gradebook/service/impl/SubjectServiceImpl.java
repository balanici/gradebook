package com.cv.gradebook.service.impl;

import com.cv.gradebook.domain.Subject;
import com.cv.gradebook.exception.ResourceNotFoundException;
import com.cv.gradebook.repository.SubjectRepository;
import com.cv.gradebook.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        return save(subject);
    }

    @Override
    public Subject findById(Long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subject not found id: %d", subjectId)));
    }

    @Override
    public Subject update(Subject newSubject, Long existingId) {
        Subject existingSubject = findById(existingId);
        BeanUtils.copyProperties(newSubject, existingSubject, "id", "grades");
        return save(existingSubject);
    }

    @Override
    public void delete(Long subjectId) {
        Subject subjectToDelete = findById(subjectId);
        subjectRepository.delete(subjectToDelete);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    private Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
}
