package com.atul.scaler.lean.arrays.pickfrombothsides;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new ArrayList<>(List.of(5, -2, 3, 1, 2)), 3, 8),
        Arguments.of(new ArrayList<>(List.of(1, 2)), 1, 2),
        Arguments.of(new ArrayList<>(List.of(10, -2, 21, 20, 11, 13, 14, 23, 4, 7)), 4, 49));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void testSolution(ArrayList<Integer> A, int B, int expected) {
    assertEquals(expected, solution.solve(A, B));
  }
}
