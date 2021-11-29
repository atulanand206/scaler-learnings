package com.atul.scaler.lean.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  static Stream<Arguments> rangeArguments() {
    return Stream.of(Arguments.of(5, 20, 15), Arguments.of(10, 15, 5), Arguments.of(100, 150, 50));
  }

  @ParameterizedTest
  @MethodSource("rangeArguments")
  void testRange(int start, int end, int count) {
    assertEquals(count, basics.streamRange(start, end).count());
    assertEquals(start, basics.streamRange(start, end).findFirst().getAsInt());
  }

  static Stream<Arguments> rangeCArguments() {
    return Stream.of(Arguments.of(5, 20, 16), Arguments.of(10, 15, 6), Arguments.of(100, 150, 51));
  }

  @ParameterizedTest
  @MethodSource("rangeCArguments")
  void testRangeC(int start, int end, int count) {
    assertEquals(count, basics.streamRangeClosed(start, end).count());
    assertEquals(start, basics.streamRangeClosed(start, end).findFirst().getAsInt());
  }

  static Stream<Arguments> mapArguments() {
    return Stream.of(
        Arguments.of(Stream.of(4, 5, 6), 3, Stream.of(12, 15, 18)),
        Arguments.of(Stream.of(12, 7, 16), 5, Stream.of(60, 35, 80)));
  }

  @ParameterizedTest
  @MethodSource("mapArguments")
  void testMapCount(Stream<Integer> input, int factor, Stream<Integer> output) {
    assertEquals(output.count(), basics.multiply(input, factor).count());
  }

  @ParameterizedTest
  @MethodSource("mapArguments")
  void testMapValue(Stream<Integer> input, int factor, Stream<Integer> output) {
    assertEquals(output.findFirst(), basics.multiply(input, factor).findFirst());
  }

  static Stream<Arguments> oneLessArguments() {
    return Stream.of(
        Arguments.of(Stream.of(4, 5, 6), Stream.of(12, 20, 30)),
        Arguments.of(Stream.of(12, 7, 16), Stream.of(132, 42, 240)));
  }

  @ParameterizedTest
  @MethodSource("oneLessArguments")
  void testOneLess(Stream<Integer> input, Stream<Integer> output) {
    assertEquals(output.count(), basics.multiplyWithOneLess(input).count());
  }

  static Stream<Arguments> prefixSumArguments() {
    return Stream.of(
        Arguments.of(Stream.of(4, 5, 6), Stream.of(4, 9, 15)),
        Arguments.of(Stream.of(12, 7, 16), Stream.of(12, 19, 35)));
  }

  @ParameterizedTest
  @MethodSource("prefixSumArguments")
  void testPrefixSum(Stream<Integer> input, Stream<Integer> output) {
    assertTrue(Basics.equalStreams(output, basics.prefixSumStream(input)));
  }
}
