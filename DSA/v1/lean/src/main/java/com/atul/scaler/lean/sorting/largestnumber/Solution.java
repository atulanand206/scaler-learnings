package com.atul.scaler.lean.sorting.largestnumber;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Given an integer array A of N integers, find the pair of integers in the array which
 * have minimum XOR value. Report the minimum XOR value.
 *
 * @author atulanand
 */
public class Solution {
  public String largestNumber(List<Integer> A) {
    String zeroes =
        A.stream()
            .filter(x -> x % 10 == 0)
            .sorted(
                Comparator.comparingInt(Solution::zeroes)
                    .thenComparing(Solution::stripped, Comparator.reverseOrder()))
            .map(String::valueOf)
            .collect(Collectors.joining());
    String nonZeroes =
        A.stream()
            .filter(x -> x % 10 != 0)
            .map(String::valueOf)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining());
    return nonZeroes + zeroes;
  }

  public String largestNumber2(List<Integer> A) {
    return A.stream()
        .map(String::valueOf)
        .sorted(
            (X, Y) -> {
              String XY = X + Y;
              String YX = Y + X;
              if (XY.equals(YX)) return 0;
              return XY.compareTo(YX) > 0 ? -1 : 1;
            })
        .collect(Collectors.joining());
  }

  private static int stripped(int t) {
    while ((t % 10) == 0) {
      t /= 10;
    }
    return t;
  }

  private static int zeroes(int t) {
    int x = 0;
    while ((t % 10) == 0) {
      t /= 10;
      x++;
    }
    return x;
  }
}
