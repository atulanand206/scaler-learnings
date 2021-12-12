package com.atul.scaler.lean.bitmanipulation.addbinarystrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.atul.scaler.lean.utils.O;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    O.attach();
    return Stream.of(Arguments.of("100", "11", "111"), Arguments.of("10110", "1111", "100101"));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(String a, String b, String expected) {
    String actual = solution.addBinary(a, b);
    assertEquals(expected, actual);
  }
}
