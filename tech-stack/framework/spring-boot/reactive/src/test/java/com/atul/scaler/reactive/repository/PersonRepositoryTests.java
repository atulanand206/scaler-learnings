package com.atul.scaler.reactive.repository;

import com.atul.scaler.reactive.domain.entity.Person;
import com.atul.scaler.reactive.domain.enums.Status;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class PersonRepositoryTests {

  @Autowired ReactiveMongoTemplate template;

  @BeforeEach
  void setup() {
    StepVerifier.create(template.dropCollection(Person.class)).verifyComplete();
  }

  @Test
  void shouldSavePerson() {
    Person person =
        new Person(BigInteger.valueOf(1), "Atul Anand", "atul@anand.com", Status.SUGGESTED);
    template.insert(Mono.just(person)).as(StepVerifier::create).expectNextCount(1).verifyComplete();
  }
}
