package com.atul.scaler.lean.arrays.flip;

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
        Arguments.of("010", new ArrayList<>(List.of(1, 1))),
        Arguments.of("111", new ArrayList<>(List.of())),
        Arguments.of("1011", new ArrayList<>(List.of(2, 2))),
        Arguments.of("10010001", new ArrayList<>(List.of(2, 7))),
        Arguments.of("01100111010100010", new ArrayList<>(List.of(9, 15))));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void testSolution(String input, ArrayList<Integer> expected) {
    assertEquals(expected, solution.flip(input));
  }
}
