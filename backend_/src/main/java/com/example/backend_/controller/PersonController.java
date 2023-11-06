package com.example.backend_.controller;

import com.example.backend_.model.Person;
import com.example.backend_.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@CrossOrigin(origins = "*")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping
    public void create(@RequestBody Person person) {
        service.create(person);
    }

    @GetMapping
    public List<Person> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public Person read(@PathVariable Long id) {
        return service.read(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Person person, @PathVariable Long id) {
        service.update(id, person);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
