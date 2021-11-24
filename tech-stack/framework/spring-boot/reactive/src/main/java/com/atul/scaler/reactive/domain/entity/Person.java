package com.atul.scaler.reactive.domain.entity;

import com.atul.scaler.reactive.domain.enums.Status;
import java.math.BigInteger;

public class Person extends BaseEntity {
  private String name;
  private String email;
  private Status status;

  public Person(BigInteger id, String name, String email, Status status) {
    super(id);
    this.name = name;
    this.email = email;
    this.status = status;
  }
}
