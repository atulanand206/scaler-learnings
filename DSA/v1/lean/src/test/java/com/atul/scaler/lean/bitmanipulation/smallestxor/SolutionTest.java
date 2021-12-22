package com.atul.scaler.lean.bitmanipulation.smallestxor;

import static org.junit.jupiter.api.Assertions.*;

import com.atul.scaler.lean.utils.O;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    O.attach();
    return Stream.of(
        Arguments.of(3, 3, 7),
        Arguments.of(15, 2, 12),
        Arguments.of(5, 6, 63),
        Arguments.of(9, 3, 11));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int a, int b, int expected) {
    int actual = solution.solve(a, b);
    assertEquals(expected, actual);
  }
}
