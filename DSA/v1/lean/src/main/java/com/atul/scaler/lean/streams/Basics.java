package com.atul.scaler.lean.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Basics {

  Stream<Integer> streamOfIntegers(int n, int x) {
    return Stream.iterate(x, e -> e + 1).limit(n);
  }

  IntStream streamFromIntArray(int[] arr) {
    return Arrays.stream(arr);
  }

  LongStream streamFromLongArray(long[] arr) {
    return Arrays.stream(arr);
  }

  Stream<String> streamFromStringList(List<String> list) {
    return list.stream();
  }
}
