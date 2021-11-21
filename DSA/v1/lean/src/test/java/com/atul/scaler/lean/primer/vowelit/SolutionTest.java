package com.atul.scaler.lean.primer.vowelit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  static Stream<Arguments> testData() {
    return Stream.of(
        Arguments.of("abcdye", "ae"),
        Arguments.of("abhishek", "aie"),
        Arguments.of("interviewbit", "ieiei"));
  }

  @ParameterizedTest
  @MethodSource("testData")
  void solve(String A, String expected) {
    Solution solution = new Solution();
    assertEquals(expected, solution.solve(A));
  }
}
