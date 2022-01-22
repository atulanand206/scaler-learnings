package com.atul.scaler.lean.sorting.largestnumber;

import static org.junit.jupiter.api.Assertions.*;

import com.atul.scaler.lean.utils.O;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    O.attach();
    return Stream.of(
        Arguments.of(List.of(3, 30, 34, 5, 9), "9534330"),
        Arguments.of(List.of(300, 30, 320, 31, 88), "883132030300"),
        Arguments.of(List.of(120, 110, 3557, 500, 90), "905003557120110F"),
        Arguments.of(List.of(31, 300, 3400, 500, 90), "31903400500300"),
        Arguments.of(List.of(2, 3, 9, 0), "9320"));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(List<Integer> a, String expected) {
    assertEquals(expected, solution.largestNumber2(a));
  }
}
