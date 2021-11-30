package com.atul.scaler.lean.arrays.sumallsubmatrices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 1}, {1, 1}}, 16),
        Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 500));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[][] input, int expected) {
    assertEquals(expected, solution.solveBruteForce(input));
  }
}
