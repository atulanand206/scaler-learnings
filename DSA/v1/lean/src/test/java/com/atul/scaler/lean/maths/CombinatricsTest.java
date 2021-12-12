package com.atul.scaler.lean.maths;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CombinatricsTest {

  private final Combinatrics combinatrics = new Combinatrics();

  static Stream<Arguments> argumentsSolve() {
    return Stream.of(
        Arguments.of(5, 2, 13, 10), Arguments.of(149, 12, 48157, 32102), Arguments.of(6, 2, 13, 2));
  }

  @ParameterizedTest
  @MethodSource("argumentsSolve")
  void testSolve(int a, int p, int m, int expected) {
    assert combinatrics.solvePrime(a, p, m) == expected;
  }
}
