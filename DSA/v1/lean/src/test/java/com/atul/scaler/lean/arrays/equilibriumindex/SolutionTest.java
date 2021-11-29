package com.atul.scaler.lean.arrays.equilibriumindex;

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
        Arguments.of(3, new ArrayList<>(List.of(-7, 1, 5, 2, -4, 3, 0))),
        Arguments.of(-1, new ArrayList<>(List.of(1, 2, 3))),
        Arguments.of(3, new ArrayList<>(List.of(1, 2, 3, 7, 1, 2, 3))),
        Arguments.of(
            0,
            new ArrayList<>(
                List.of(
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0))),
        Arguments.of(-1, new ArrayList<>(List.of(1, 2, 3))),
        Arguments.of(-1, new ArrayList<>(List.of(1, 2, 3))),
        Arguments.of(-1, new ArrayList<>(List.of(1, 2, 3))));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void testSolution(int expected, ArrayList<Integer> input) {
    solution.solve(input);
    assertEquals(expected, solution.solve(input));
  }
}
