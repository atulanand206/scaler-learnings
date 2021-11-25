package com.atul.scaler.lean.arrays.mergeintervals;

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
        Arguments.of(
            List.of(new Interval(1, 5), new Interval(6, 9)),
            new Interval(2, 6),
            List.of(new Interval(1, 9))),
        Arguments.of(
            List.of(new Interval(1, 5), new Interval(6, 9)),
            new Interval(2, 5),
            List.of(new Interval(1, 5), new Interval(6, 9))),
        Arguments.of(
            List.of(new Interval(1, 5), new Interval(6, 9), new Interval(11, 13)),
            new Interval(9, 11),
            List.of(new Interval(1, 5), new Interval(6, 13))));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Interval> input, Interval interval, List<Interval> expected) {
    ArrayList<Interval> inputAL = new ArrayList<>(input);
    List<Interval> actual = solution.insert(inputAL, interval);
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++)
      assertEquals(expected.get(i).toString(), actual.get(i).toString());
  }
}
