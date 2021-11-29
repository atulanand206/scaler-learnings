package com.atul.scaler.lean.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

  IntStream streamRange(int start, int end) {
    return IntStream.range(start, end);
  }

  IntStream streamRangeClosed(int start, int end) {
    return IntStream.rangeClosed(start, end);
  }

  Stream<Integer> multiply(Stream<Integer> input, int factor) {
    return input.map(e -> e * factor);
  }

  Stream<Integer> multiplyWithOneLess(Stream<Integer> input) {
    return input.map(e -> e * (e - 1));
  }

  Stream<Integer> prefixSumStream(Stream<Integer> stream) {
    List<Integer> prefixSum =
        stream.collect(
            Collector.of(
                ArrayList::new,
                (a, b) -> a.add(a.isEmpty() ? b : (b + a.get(a.size() - 1))),
                (a, b) -> {
                  throw new UnsupportedOperationException();
                }));
    return prefixSum.stream();
  }

  public static boolean equalStreams(Stream<?>... streams) {
    List<Iterator<?>> is =
        Arrays.stream(streams).map(Stream::iterator).collect(Collectors.toList());

    while (is.stream().allMatch(Iterator::hasNext))
      if (is.stream().map(Iterator::next).distinct().limit(2).count() > 1) return false;

    return is.stream().noneMatch(Iterator::hasNext);
  }
}
