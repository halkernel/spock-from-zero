package com.spock.controller;



import com.spock.exceptions.EntityNotFoundException;
import com.spock.exceptions.InvalidPayloadException;
import com.spock.model.Person;
import com.spock.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity getPerson(@PathVariable Integer id){
        Person response = personService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person){
        try {
            Person response = personService.save(person);
            return ResponseEntity
                    .created(URI.create("/persons/" + response.getId()))
                    .body(response);
        }catch (InvalidPayloadException ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity getPersons(){
        try{
            List<Person> response =  personService.findAll();
            return ResponseEntity.ok(response);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.noContent().build();
        }

    }

}
