package com.atul.scaler.lean.arrays.addone;

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
        Arguments.of(List.of(1, 4, 4), List.of(1, 4, 5)),
        Arguments.of(List.of(0, 0, 3, 9, 9), List.of(4, 0, 0)),
        Arguments.of(List.of(0, 0, 0, 0, 0, 0, 0), List.of(1)),
        Arguments.of(List.of(9, 9, 9), List.of(1, 0, 0, 0)));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Integer> input, List<Integer> expected) {
    ArrayList<Integer> inputAL = new ArrayList<>(input);
    List<Integer> actual = solution.plusOne(inputAL);
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++)
      assertEquals(expected.get(i).toString(), actual.get(i).toString());
  }
}
