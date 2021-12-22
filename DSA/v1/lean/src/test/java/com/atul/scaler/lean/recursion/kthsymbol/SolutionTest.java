package com.atul.scaler.lean.recursion.kthsymbol;

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
    return Stream.of(Arguments.of(2, 1, 0), Arguments.of(2, 2, 1));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int a, int b, int expected) {
    int actual = solution.solve(a, b);
    assertEquals(expected, actual);
  }
}
