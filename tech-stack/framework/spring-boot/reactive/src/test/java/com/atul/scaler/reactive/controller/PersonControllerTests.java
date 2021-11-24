package com.atul.scaler.reactive.controller;

import com.atul.scaler.reactive.domain.entity.Person;
import com.atul.scaler.reactive.domain.enums.Status;
import com.atul.scaler.reactive.repository.IPersonRepository;
import com.atul.scaler.reactive.service.v1.PersonService;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = PersonController.class)
@Import(PersonService.class)
public class PersonControllerTests {

  @Autowired private IPersonRepository personRepository;

  @Autowired private WebTestClient webTestClient;

  @Test
  void testSavePerson() {
    Person person =
        new Person(BigInteger.valueOf(1), "Atul Anand", "atul@anand.com", Status.SUGGESTED);
    Mockito.when(personRepository.save(person)).thenReturn(Mono.just(person));
    webTestClient
        .mutate()
        .defaultHeaders(
            headers -> headers.add("Content-Type", MediaType.APPLICATION_JSON.getType()))
        .build()
        .post()
        .uri("/api/v1/persons")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(person)
        .exchange();
  }
}
