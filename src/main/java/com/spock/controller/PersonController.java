package com.spock.controller;


import com.spock.enums.ControllerConstants;
import com.spock.model.Person;
import com.spock.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public ResponseEntity getPerson(@PathVariable Integer id){
        Person response = personRepository.findById(id).get();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person){
        Person response = personRepository.save(person);
        return ResponseEntity
                .created(URI.create("/persons/" + response.getId()))
                .body(response);
    }

}
