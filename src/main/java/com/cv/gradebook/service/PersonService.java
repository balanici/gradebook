package com.cv.gradebook.service;

import com.cv.gradebook.domain.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person);

    Person findById(Long personId);

    Person update(Person newPerson, Long existingId);

    void delete(Long personId);

    List<Person> findAll();
}
