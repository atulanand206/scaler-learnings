package com.atul.scaler.lean.binarysearch.squareroot;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.atul.scaler.lean.utils.O;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  Solution solution = new Solution();

  static Stream<Arguments> arguments() {
    O.attach();
    return Stream.of(
        Arguments.of(11, 3),
        Arguments.of(2147483647, 46340),
        Arguments.of(9, 3),
        Arguments.of(3, 1));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int a, int expected) {
    int actual = solution.sqrt(a);
    assertEquals(expected, actual);
  }

  @Test
  void x() {
    char[] chars = {'H', 'Y', 'P', 'E', 'R', '-', 'S', 'K', 'I', 'L', 'L'};

    String stringFromChars = String.valueOf(chars);

    String[] strings = stringFromChars.split("-");

    System.out.println(strings[1]);
  }
}
