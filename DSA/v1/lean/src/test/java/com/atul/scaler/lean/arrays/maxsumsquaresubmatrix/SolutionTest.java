package com.atul.scaler.lean.arrays.maxsumsquaresubmatrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}
            },
            3,
            48),
        Arguments.of(
            new int[][] {
              {1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}
            },
            4,
            68),
        Arguments.of(new int[][] {{2, 2}, {2, 2}}, 2, 8));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[][] input, int val, int expected) {
    assertEquals(expected, solution.solve(input, val));
  }
}
