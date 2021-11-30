package com.atul.scaler.lean.arrays.submatrixsumqueries;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(
            new int[][] {{5, 17, 100, 11}, {0, 0, 2, 8}},
            new int[] {1, 1},
            new int[] {1, 4},
            new int[] {2, 2},
            new int[] {2, 4},
            new int[] {22, 19}),
        Arguments.of(
            new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[] {1, 2},
            new int[] {1, 2},
            new int[] {2, 3},
            new int[] {2, 3},
            new int[] {12, 28}));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[][] A, int[] B, int[] C, int[] D, int[] E, int[] expected) {
    assertArrayEquals(expected, solution.solve(A, B, C, D, E));
  }
}
