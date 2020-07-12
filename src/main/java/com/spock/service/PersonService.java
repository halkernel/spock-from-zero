package com.spock.service;

import com.spock.exceptions.EntityNotFoundException;
import com.spock.model.Person;
import com.spock.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person save(Person person){
        return personRepository.save(person);
    }

    public Person findById(Integer id){
        try{
            return personRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new EntityNotFoundException("Entity with id: " + id + " not found" );
        }
    }

}
