package com.atul.scaler.lean.arrays.beggarsoutsidetemple;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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
        Arguments.of(
            5,
            new ArrayList<>(
                List.of(
                    new ArrayList<>(List.of(1, 2, 10)),
                    new ArrayList<>(List.of(2, 3, 20)),
                    new ArrayList<>(List.of(2, 5, 25)))),
            new ArrayList<>(List.of(10, 55, 45, 25, 25))),
        Arguments.of(
            20,
            new ArrayList<>(
                List.of(
                    new ArrayList<>(List.of(1, 7, 8)),
                    new ArrayList<>(List.of(4, 13, 27)),
                    new ArrayList<>(List.of(3, 18, 7)),
                    new ArrayList<>(List.of(9, 10, 44)),
                    new ArrayList<>(List.of(6, 7, 39)),
                    new ArrayList<>(List.of(5, 13, 45)),
                    new ArrayList<>(List.of(11, 14, 38)),
                    new ArrayList<>(List.of(2, 11, 42)),
                    new ArrayList<>(List.of(14, 19, 93)),
                    new ArrayList<>(List.of(14, 15, 25)))),
            new ArrayList<>(
                List.of(
                    8, 50, 57, 84, 129, 168, 168, 121, 165, 165, 159, 117, 117, 163, 125, 100, 100,
                    100, 93, 0))));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void testSolution(int beggars, ArrayList<ArrayList<Integer>> input, ArrayList<Integer> expected) {
    ArrayList<Integer> actual = solution.solve(beggars, input);
    assertIterableEquals(expected, actual);
  }
}
