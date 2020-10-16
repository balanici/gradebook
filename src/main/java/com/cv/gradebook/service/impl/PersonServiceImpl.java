package com.cv.gradebook.service.impl;

import com.cv.gradebook.domain.Person;
import com.cv.gradebook.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Person findById(Long personId) {
        return null;
    }

    @Override
    public Person update(Person newPerson, Long existingId) {
        return null;
    }

    @Override
    public void delete(Long personId) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
