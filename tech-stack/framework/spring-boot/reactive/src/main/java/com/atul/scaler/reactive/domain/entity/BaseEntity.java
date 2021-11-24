package com.atul.scaler.reactive.domain.entity;

import java.math.BigInteger;

public abstract class BaseEntity {
  private BigInteger id;

  public BaseEntity(BigInteger id) {
    this.id = id;
  }
}
