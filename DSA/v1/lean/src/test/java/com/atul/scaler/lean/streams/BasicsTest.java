package com.atul.scaler.lean.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicsTest {

  Basics basics = new Basics();

  static Stream<Arguments> arguments() {
    return Stream.of(Arguments.of(5, 4), Arguments.of(10, 5), Arguments.of(100, 50));
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void testAsda(int n, int start) {
    assertEquals(n, basics.streamOfIntegers(n, start).count());
    assertEquals(start, basics.streamOfIntegers(n, start).findFirst().get());
  }

  static Stream<Arguments> arrayArguments() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 5),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
  }

  @ParameterizedTest
  @MethodSource("arrayArguments")
  void testIntArrayStream(int[] n, int count) {
    assertEquals(count, basics.streamFromIntArray(n).count());
  }

  static Stream<Arguments> arraylongArguments() {
    return Stream.of(
        Arguments.of(new long[] {1, 2, 3, 4, 5}, 5),
        Arguments.of(new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
  }

  @ParameterizedTest
  @MethodSource("arraylongArguments")
  void testLongArrayStream(long[] n, int count) {
    assertEquals(count, basics.streamFromLongArray(n).count());
  }

  static Stream<Arguments> stringListArguments() {
    return Stream.of(
        Arguments.of(List.of("asd", "dsad"), 2), Arguments.of(List.of("assASasd", "dsASassad"), 2));
  }

  @ParameterizedTest
  @MethodSource("stringListArguments")
  void testStringListStream(List<String> n, int count) {
    assertEquals(count, basics.streamFromStringList(n).count());
  }
}
