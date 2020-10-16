package com.cv.gradebook.service;

import com.cv.gradebook.domain.Mark;

import java.util.List;

public interface MarkService {

    Mark create(Mark mark);

    Mark findById(Long markId);

    Mark update(Mark newMark, Long existingId);

    void delete(Long markId);

    List<Mark> findAll();
}
