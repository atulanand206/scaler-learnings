package com.atul.scaler.lean.primer.maxmod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  static Stream<Arguments> argsTestSolve() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 44, 3}, 3),
        Arguments.of(new int[] {2, 6, 4}, 4),
        Arguments.of(new int[] {5, 5, 5, 5, 5}, 0));
  }

  @MethodSource("argsTestSolve")
  @ParameterizedTest
  void testSolve(int[] input, long output) {
    assertEquals(output, new Solution().solve(input));
  }
}
