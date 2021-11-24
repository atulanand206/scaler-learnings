package com.atul.scaler.reactive.service;

import com.atul.scaler.reactive.domain.entity.Person;
import reactor.core.publisher.Mono;

public interface IPersonService {

  public Mono<Person> createPerson(Person person);

  public Mono<Person> findPerson(String id);
}
