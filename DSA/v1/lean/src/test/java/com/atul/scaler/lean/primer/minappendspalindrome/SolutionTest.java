package com.atul.scaler.lean.primer.minappendspalindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  static Stream<Arguments> testData() {
    return Stream.of(Arguments.of("abede", 2), Arguments.of("aabb", 2));
  }

  @ParameterizedTest
  @MethodSource("testData")
  void solve(String A, int expected) {
    Solution solution = new Solution();
    int actual = solution.solve(A);
    assertEquals(expected, actual);
  }
}
