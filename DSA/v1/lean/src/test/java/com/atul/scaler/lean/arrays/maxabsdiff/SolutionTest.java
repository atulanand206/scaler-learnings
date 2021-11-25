package com.atul.scaler.lean.arrays.maxabsdiff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(List.of(1, 3, -1), 5),
        Arguments.of(List.of(2), 0),
        Arguments.of(List.of(1, 2, 3), 4),
        Arguments.of(List.of(5, 4, 3, 2, 1), 8),
        Arguments.of(List.of(4, 2, 3, 5, 1, 9, 8, 6), 11));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Integer> input, int expected) {
    assertEquals(expected, solution.maxArr(new ArrayList<>(input)));
  }
}
