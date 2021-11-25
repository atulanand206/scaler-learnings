package com.atul.scaler.lean.arrays.maxnonnegsubarray;

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
        Arguments.of(List.of(1, 2, 5, -7, 2, 3), List.of(1, 2, 5)),
        Arguments.of(List.of(10, -1, 2, 3, -4, 100), List.of(100)),
        Arguments.of(List.of(0, 0, -1, 0), List.of(0, 0)),
        Arguments.of(
            List.of(1967513926, 1540383426, -1303455736, -521595368),
            List.of(1967513926, 1540383426)));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Integer> input, List<Integer> expected) {
    ArrayList<Integer> inputAL = new ArrayList<>(input);
    List<Integer> actual = solution.maxNonNegativeSubArray(inputAL);
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++)
      assertEquals(expected.get(i).toString(), actual.get(i).toString());
  }
}
