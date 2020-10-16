package com.cv.gradebook.service.impl;

import com.cv.gradebook.domain.Grade;
import com.cv.gradebook.exception.ResourceNotFoundException;
import com.cv.gradebook.repository.GradeRepository;
import com.cv.gradebook.service.GradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade create(Grade grade) {
        grade.setId(null);//ensure will create new one :)
        return saveGrade(grade);
    }

    @Override
    public Grade findById(Long gradeId) {
        return gradeRepository.findById(gradeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Grade not found. id:%d", gradeId)
                ));
    }

    @Override
    public Grade update(Grade newGrade, Long existingId) {
        Grade existingGrade = findById(existingId);
        BeanUtils.copyProperties(newGrade, existingGrade, "id", "gradeMembers", "subjects");
        return saveGrade(existingGrade);
    }

    @Override
    public void delete(Long gradeId) {
        gradeRepository.delete(findById(gradeId));
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    private Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
}
