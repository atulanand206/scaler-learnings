package com.atul.scaler.lean.arrays.firstmissinginteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 0}, 3),
        Arguments.of(new int[] {3, 4, -1, 1}, 2),
        Arguments.of(new int[] {-8, -7, -6}, 1),
        Arguments.of(new int[] {2, 3, 5, 4, 1, 8, 7, 6, 9, 11}, 10),
        Arguments.of(new int[] {1, 5, 9, 7, 26, 12, 11, 9, 8, 7, 4, 3, 2, 6, 10}, 13),
        Arguments.of(
            new int[] {20, 18, 15, 1, 5, 9, 14, 13, 7, 12, 11, 9, 8, 7, 4, 3, 2, 16, 6, 10}, 17));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] input, int expected) {
    assertEquals(expected, solution.firstMissingPositive(input));
  }
}
