package com.atul.scaler.lean.bitmanipulation.counttotalsetbits;

import static org.junit.jupiter.api.Assertions.*;

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
    return Stream.of(Arguments.of(1, 1), Arguments.of(3, 4));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  public void test(int a, int expected) {
    int actual = solution.solve(a);
    assertEquals(expected, actual);
  }

  @Test
  public void print() {
    O.attach();
    long y = 0;
    for (int i = 0; i < 100; i++) {
      String aBin = Integer.toBinaryString(i);
      int length = aBin.length() - 1;
      int MSB = (1 << length);
      O.debug(String.format("%4d  ", i));
      O.debug(String.format("%7s  ", aBin));
      O.debug(String.format("%7d  ", MSB));
      y += solution.countOnes(aBin);
      O.debug(String.format("%3d  ", solution.solve(i)));
      O.debug(String.format("%3d  ", y));
      O.debugNewLine();
    }
  }
}
