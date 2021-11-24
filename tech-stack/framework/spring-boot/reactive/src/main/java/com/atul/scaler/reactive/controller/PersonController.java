package com.atul.scaler.reactive.controller;

import com.atul.scaler.reactive.domain.entity.Person;
import com.atul.scaler.reactive.service.v1.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

  @Autowired private PersonService personService;

  @PostMapping
  public Mono<Person> createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

  @GetMapping("/{id}")
  public Mono<Person> getEmployeeById(@PathVariable String id) {
    return personService.findPerson(id);
  }
}
