package com.cv.gradebook.service.impl;

import com.cv.gradebook.domain.Person;
import com.cv.gradebook.exception.ResourceNotFoundException;
import com.cv.gradebook.repository.PersonRepository;
import com.cv.gradebook.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        person.setId(null);
        return save(person);
    }

    @Override
    public Person findById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() ->new ResourceNotFoundException(String.format("Person with not found id: %d", personId)));
    }

    @Override
    public Person update(Person newPerson, Long existingId) {
        Person existingPerson = findById(existingId);
        BeanUtils.copyProperties(newPerson, existingPerson,
                "id", "personType", "classMaster", "grade", "classPupils", "receivedMarks", "sentMarks");
        return save(existingPerson);
    }

    @Override
    public void delete(Long personId) {
        Person personToDelete = findById(personId);
        personRepository.delete(personToDelete);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    private Person save(Person person) {
        return personRepository.save(person);
    }
}
