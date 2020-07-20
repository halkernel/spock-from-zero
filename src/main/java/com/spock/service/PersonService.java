package com.spock.service;

import com.spock.exceptions.EntityNotFoundException;
import com.spock.exceptions.InvalidPayloadException;
import com.spock.model.Person;
import com.spock.repository.PersonRepository;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        try{
            return personRepository.save(person);
        }catch (InvalidPropertyException ex){
            throw new InvalidPayloadException("Payload is not valid for this entity");
        }
    }

    public Person findById(Integer id){
        try{
            return personRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new EntityNotFoundException("Entity with id: " + id + " not found" );
        }
    }

    public List<Person> findAll(){
        List<Person> persons = personRepository.findAll();
        if(persons.isEmpty()) {
            throw new EntityNotFoundException("No person was found");
        }
        return persons;
    }

}
