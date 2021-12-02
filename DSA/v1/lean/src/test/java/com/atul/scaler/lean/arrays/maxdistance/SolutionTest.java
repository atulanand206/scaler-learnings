package com.atul.scaler.lean.arrays.maxdistance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[] {3, 5, 4, 2}, 2),
        Arguments.of(new int[] {5, 17, 100, 110}, 3),
        Arguments.of(new int[] {-1, -1, 2}, 2));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] input, int expected) {
    assertEquals(expected, solution.maximumGap(input));
  }
}
