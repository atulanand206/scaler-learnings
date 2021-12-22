package com.atul.scaler.lean.bitmanipulation.reversebits;

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
    return Stream.of(Arguments.of(3L, 3221225472L), Arguments.of(0L, 0L));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(long a, long expected) {
    assertEquals(expected, solution.reverse(a));
  }
}
