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

  @ParameterizedTest
  @MethodSource("print2DArrayArguments")
  void testPrint2DArrayStream(int[][] n, int count) {
    Basics.print2dArray(n, count);
  }

  static Stream<Arguments> print2DArrayArguments() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 2, 3, 4, 5}}, 1),
        Arguments.of(
            new int[][] {
              {
                1, 2, 5, 7, 10, 11, 12, 13, 14, 17, 19, 20, 23, 24, 27, 28, 29, 30, 31, 32, 34, 35,
                37, 39, 40, 41, 42, 43, 45, 46, 47, 50, 53
              },
              {
                4, 6, 8, 10, 11, 13, 15, 18, 20, 21, 24, 25, 27, 30, 33, 36, 37, 40, 41, 42, 43, 44,
                45, 48, 51, 54, 55, 56, 59, 62, 63, 65, 66
              },
              {
                7, 8, 11, 14, 17, 19, 22, 25, 27, 29, 30, 31, 34, 36, 37, 40, 42, 44, 45, 48, 49,
                52, 55, 58, 60, 63, 66, 69, 70, 73, 76, 78, 79
              },
              {
                10, 11, 13, 17, 19, 22, 23, 26, 30, 31, 33, 36, 38, 41, 43, 45, 46, 48, 49, 50, 53,
                55, 58, 59, 63, 66, 69, 70, 71, 75, 77, 80, 82
              },
              {
                13, 16, 17, 20, 22, 23, 26, 27, 31, 32, 36, 39, 41, 44, 47, 50, 52, 55, 58, 61, 63,
                66, 68, 71, 72, 75, 77, 78, 80, 81, 82, 84, 85
              },
              {
                15, 19, 22, 25, 28, 29, 31, 34, 36, 38, 41, 42, 44, 45, 50, 51, 55, 58, 60, 64, 66,
                69, 72, 75, 77, 80, 83, 84, 86, 89, 90, 93, 96
              },
              {
                16, 21, 23, 28, 29, 32, 34, 36, 38, 39, 42, 45, 47, 48, 52, 54, 57, 60, 62, 66, 69,
                72, 74, 76, 79, 81, 84, 86, 88, 91, 93, 96, 99
              },
              {
                19, 22, 25, 31, 33, 36, 38, 39, 41, 43, 44, 48, 50, 52, 54, 55, 58, 62, 64, 67, 71,
                75, 76, 77, 81, 83, 86, 87, 90, 93, 95, 97, 100
              },
              {
                21, 24, 26, 32, 36, 37, 41, 43, 46, 47, 49, 52, 54, 56, 58, 60, 63, 64, 66, 68, 72,
                76, 79, 82, 85, 87, 88, 91, 92, 95, 98, 100, 102
              },
              {
                24, 25, 27, 33, 39, 42, 44, 45, 48, 50, 51, 53, 56, 57, 61, 62, 65, 68, 69, 70, 74,
                79, 81, 83, 87, 90, 92, 94, 96, 99, 100, 103, 106
              },
              {
                25, 28, 31, 35, 40, 43, 46, 49, 50, 52, 55, 56, 58, 60, 63, 65, 68, 71, 74, 76, 79,
                81, 82, 85, 89, 92, 93, 96, 99, 100, 103, 104, 107
              },
              {
                26, 31, 32, 38, 43, 46, 48, 52, 55, 57, 60, 62, 65, 66, 68, 69, 70, 72, 77, 78, 80,
                83, 86, 88, 91, 94, 95, 98, 102, 103, 104, 107, 110
              },
              {
                29, 33, 36, 39, 45, 48, 49, 53, 56, 59, 63, 65, 66, 67, 70, 71, 74, 75, 80, 81, 82,
                85, 89, 90, 93, 96, 99, 101, 105, 107, 110, 112, 114
              },
              {
                30, 34, 39, 40, 48, 51, 52, 56, 58, 61, 64, 68, 71, 73, 76, 79, 81, 84, 86, 87, 90,
                93, 94, 96, 99, 101, 103, 104, 108, 109, 112, 113, 115
              },
              {
                32, 35, 40, 42, 50, 54, 55, 57, 61, 63, 65, 71, 74, 76, 79, 82, 83, 86, 87, 89, 91,
                94, 95, 99, 102, 103, 106, 107, 111, 114, 115, 116, 117
              },
              {
                35, 38, 42, 44, 51, 57, 59, 60, 64, 66, 67, 72, 76, 78, 81, 85, 86, 88, 89, 92, 93,
                97, 100, 102, 103, 104, 107, 110, 114, 116, 119, 122, 123
              },
              {
                36, 39, 43, 47, 53, 58, 61, 63, 66, 69, 71, 73, 77, 80, 82, 87, 88, 89, 90, 94, 95,
                98, 101, 103, 104, 105, 109, 113, 117, 120, 121, 125, 127
              },
              {
                37, 42, 45, 50, 55, 59, 64, 65, 69, 70, 72, 75, 79, 82, 84, 89, 90, 92, 93, 96, 97,
                99, 104, 107, 109, 110, 112, 116, 119, 123, 125, 126, 128
              },
              {
                38, 45, 47, 53, 57, 61, 67, 69, 72, 75, 76, 79, 80, 84, 85, 92, 93, 96, 99, 102,
                103, 105, 107, 110, 111, 113, 115, 118, 121, 126, 129, 130, 133
              },
              {
                39, 47, 49, 56, 60, 64, 68, 70, 74, 77, 80, 83, 85, 87, 89, 94, 96, 98, 102, 105,
                108, 110, 113, 114, 117, 119, 121, 123, 124, 129, 130, 131, 135
              },
              {
                40, 50, 53, 57, 63, 65, 70, 72, 76, 79, 82, 86, 87, 90, 93, 95, 98, 99, 105, 106,
                111, 112, 115, 117, 120, 122, 125, 128, 131, 132, 133, 136, 138
              },
              {
                41, 51, 56, 58, 65, 68, 72, 73, 77, 80, 85, 87, 90, 93, 95, 98, 101, 103, 106, 109,
                114, 115, 116, 118, 123, 126, 127, 129, 134, 136, 137, 140, 141
              },
              {
                44, 53, 59, 62, 67, 69, 75, 76, 79, 81, 88, 91, 92, 95, 96, 99, 104, 106, 109, 110,
                116, 118, 120, 123, 126, 127, 129, 132, 135, 139, 140, 141, 143
              },
              {
                47, 54, 60, 63, 70, 72, 76, 77, 81, 83, 91, 93, 95, 97, 99, 102, 105, 108, 110, 113,
                118, 121, 123, 126, 129, 130, 132, 134, 137, 142, 144, 147, 150
              },
              {
                50, 57, 61, 65, 73, 74, 77, 78, 83, 86, 92, 95, 96, 99, 101, 103, 107, 111, 113,
                114, 120, 122, 126, 128, 132, 134, 136, 139, 141, 145, 147, 149, 151
              },
              {
                52, 58, 62, 67, 76, 77, 79, 81, 86, 88, 94, 96, 98, 102, 104, 105, 109, 112, 116,
                118, 123, 126, 128, 130, 133, 136, 138, 141, 142, 146, 148, 152, 153
              },
              {
                55, 61, 63, 69, 78, 81, 84, 86, 88, 90, 97, 99, 101, 104, 105, 106, 112, 114, 119,
                122, 125, 128, 130, 132, 136, 138, 139, 142, 143, 147, 149, 153, 155
              },
              {
                58, 62, 64, 71, 79, 82, 87, 89, 90, 93, 99, 102, 104, 107, 109, 112, 115, 118, 120,
                124, 128, 129, 131, 133, 138, 141, 144, 147, 149, 151, 153, 154, 156
              },
              {
                60, 65, 68, 72, 80, 84, 88, 92, 94, 96, 101, 104, 105, 109, 112, 114, 117, 119, 123,
                126, 130, 131, 132, 135, 140, 144, 147, 148, 152, 154, 156, 159, 162
              },
              {
                62, 66, 71, 74, 82, 87, 89, 93, 97, 100, 102, 107, 108, 111, 114, 116, 118, 120,
                124, 129, 131, 132, 134, 138, 143, 146, 149, 151, 155, 157, 158, 161, 164
              },
              {
                64, 69, 72, 77, 84, 90, 92, 94, 100, 103, 106, 109, 111, 114, 116, 117, 119, 121,
                125, 131, 134, 137, 139, 141, 145, 149, 151, 152, 157, 159, 162, 163, 165
              },
              {
                65, 70, 75, 80, 85, 93, 95, 98, 101, 105, 108, 112, 115, 116, 117, 120, 121, 124,
                126, 132, 137, 140, 141, 144, 147, 152, 153, 156, 159, 161, 163, 164, 168
              },
              {
                66, 72, 76, 82, 87, 94, 96, 101, 103, 108, 110, 113, 117, 118, 120, 121, 123, 125,
                128, 134, 139, 141, 143, 147, 148, 155, 158, 160, 161, 163, 164, 166, 171
              },
              {
                68, 75, 77, 85, 90, 97, 98, 104, 107, 109, 112, 114, 120, 121, 122, 124, 125, 128,
                129, 135, 142, 145, 146, 148, 150, 157, 161, 163, 165, 168, 171, 172, 174
              },
              {
                71, 77, 79, 86, 91, 99, 101, 107, 108, 112, 113, 116, 122, 125, 127, 130, 132, 134,
                135, 138, 144, 147, 149, 151, 153, 158, 162, 164, 167, 170, 174, 177, 178
              },
              {
                74, 78, 80, 89, 94, 101, 104, 110, 112, 115, 117, 120, 125, 127, 130, 131, 135, 138,
                139, 140, 145, 149, 152, 155, 157, 160, 165, 166, 168, 173, 176, 178, 181
              },
              {
                75, 81, 83, 92, 97, 102, 105, 112, 113, 118, 121, 123, 127, 130, 133, 134, 136, 139,
                141, 142, 146, 151, 154, 157, 159, 162, 167, 168, 171, 174, 179, 181, 183
              }
            },
            3),
        Arguments.of(new int[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}, 2));
  }
}
