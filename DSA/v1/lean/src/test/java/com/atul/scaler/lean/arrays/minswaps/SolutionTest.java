package com.atul.scaler.lean.arrays.minswaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[] {1, 12, 10, 3, 14, 10, 5}, 8, 2),
        Arguments.of(new int[] {5, 17, 100, 11}, 20, 1));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] input, int val, int expected) {
    assertEquals(expected, solution.solve(input, val));
  }
}
