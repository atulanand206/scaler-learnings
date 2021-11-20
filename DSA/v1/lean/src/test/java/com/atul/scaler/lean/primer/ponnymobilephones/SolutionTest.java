package com.atul.scaler.lean.primer.ponnymobilephones;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(new int[] {3, 4, 4, 6}, new int[] {20, 4, 10, 2}, new int[] {4, 1, 2, 0}));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int[] A, int[] B, int[] expected) {
    assertArrayEquals(expected, new Solution().solve(A, B));
  }
}
