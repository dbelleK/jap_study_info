package com.fastcampus.javaallinone.project2.demo.controller;

import com.fastcampus.javaallinone.project2.demo.domain.Person;
import com.fastcampus.javaallinone.project2.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    @RequestMapping(value = "/{id}")
    public Person getPerson(@PathVariable Long id){

        return personService.getPerson(id);

    }
}
