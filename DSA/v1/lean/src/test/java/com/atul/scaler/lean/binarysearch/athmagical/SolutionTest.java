package com.atul.scaler.lean.binarysearch.athmagical;

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
        Arguments.of(19, 11, 13, 117), Arguments.of(1, 2, 3, 2), Arguments.of(4, 2, 3, 6));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int a, int b, int c, int expected) {
    int actual = solution.solve(a, b, c);
    assertEquals(expected, actual);
  }
}
