package com.atul.scaler.reactive.service.v1;

import com.atul.scaler.reactive.domain.entity.Person;
import com.atul.scaler.reactive.repository.IPersonRepository;
import com.atul.scaler.reactive.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PersonService implements IPersonService {

  @Autowired private IPersonRepository personRepository;

  @Override
  public Mono<Person> createPerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  public Mono<Person> findPerson(String id) {
    return null;
  }
}
