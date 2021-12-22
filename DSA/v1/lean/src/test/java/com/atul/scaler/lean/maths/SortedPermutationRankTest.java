package com.atul.scaler.lean.maths;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortedPermutationRankTest {

  private final SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();

  static Stream<Arguments> argumentsSolve() {
    return Stream.of(Arguments.of("acb", 2), Arguments.of("a", 1), Arguments.of("VIEW", 15));
  }

  @ParameterizedTest
  @MethodSource("argumentsSolve")
  void testSolve(String input, int expected) {
    assert sortedPermutationRank.findRank(input) == expected;
  }
}
