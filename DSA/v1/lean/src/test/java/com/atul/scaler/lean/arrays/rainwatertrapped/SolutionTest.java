package com.atul.scaler.lean.arrays.rainwatertrapped;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[] {0, 1, 0, 2}, 1),
        Arguments.of(new int[] {1, 2}, 0),
        Arguments.of(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
        Arguments.of(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 17),
        Arguments.of(
            new int[] {
              56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81,
              70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33,
              75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77
            },
            2107));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] input, int expected) {
    assertEquals(expected, solution.trap(input));
  }
}
