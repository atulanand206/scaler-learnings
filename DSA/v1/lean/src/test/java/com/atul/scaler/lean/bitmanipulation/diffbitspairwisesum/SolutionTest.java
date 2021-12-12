package com.atul.scaler.lean.bitmanipulation.diffbitspairwisesum;

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
        Arguments.of(new int[] {1, 3, 5}, 8),
        Arguments.of(new int[] {2, 3}, 2),
        Arguments.of(new int[] {81, 13, 2, 7, 96}, 72));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] a, int expected) {
    int actual = solution.cntBits(a);
    assertEquals(expected, actual);
  }
}
