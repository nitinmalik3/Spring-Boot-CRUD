package com.example.springmongodemo.controller;

import com.example.springmongodemo.model.Person;
import com.example.springmongodemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.create(firstName, lastName, age);
        return p.toString();
    }

    @GetMapping("/get/{firstName}")
    public Person getPerson(@PathVariable String firstName) {
        return personService.findByFirstName(firstName);
    }

    @GetMapping("/getAll")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @PutMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.update(firstName, lastName, age);
        return p.toString();
    }

    @DeleteMapping("/delete/{firstName}")
    public String delete(@PathVariable String firstName) {
        personService.delete(firstName);
        return "Deleted " + firstName;
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "Deleted All Records!";
    }
}
