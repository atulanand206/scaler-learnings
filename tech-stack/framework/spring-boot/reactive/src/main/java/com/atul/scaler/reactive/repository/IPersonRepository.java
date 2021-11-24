package com.atul.scaler.reactive.repository;

import com.atul.scaler.reactive.domain.entity.Person;
import java.math.BigInteger;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends ReactiveCrudRepository<Person, BigInteger> {}
