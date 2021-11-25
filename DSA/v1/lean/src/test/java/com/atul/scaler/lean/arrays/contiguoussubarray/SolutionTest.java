package com.atul.scaler.lean.arrays.contiguoussubarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(List.of(1, 2, 3, 4, -10), 10),
        Arguments.of(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
        Arguments.of(List.of(-8, -3, -6, -2, -5, -4), -2),
        Arguments.of(List.of(-1, -5, 2, 4, 9, -8), 15));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Integer> input, int expected) {
    int actual = solution.maxSubArray(input);
    assertEquals(expected, actual);
  }
}
