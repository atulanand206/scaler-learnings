package com.atul.scaler.lean.arrays.maxdistance;

/**
 * Problem: Given an array A of integers of size N. Find the maximum of value of j - i such that
 * A[i] <= A[j].
 *
 * <p>Problem Constraints:
 *
 * <p>1 <= length of the array <= 1000000
 *
 * <p>-10^9 <= A[i], B <= 10^9
 *
 * <p>Input: First argument is an integer array A of size N.
 *
 * <p>Output: Return an integer denoting the maximum value of j - i.
 *
 * <p>Approach:
 *
 * <p>This will take O(n) time complexity & O(1) space complexity.
 *
 * @author atulanand
 */
public class Solution {
  static class Pair {
    int key;
    int value;

    Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }

    int getKey() {
      return key;
    }

    int getValue() {
      return value;
    }
  }

  public int maximumGap(final int[] A) {
    int n = A.length;
    int[] rightMax = new int[n];
    rightMax[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], A[i]);
    int maxDist = Integer.MIN_VALUE;
    int i = 0, j = 0;
    while (i < n && j < n)
      if (rightMax[j] >= A[i]) {
        maxDist = Math.max(maxDist, j - i);
        j++;
      } else i++;
    return maxDist;
    // final int[] res = new int[] {A.length, Integer.MIN_VALUE};
    // List<Pair> lst =
    //     IntStream.range(0, A.length)
    //         .boxed()
    //         .map(entry -> new Pair(A[entry], entry))
    //         .sorted(Comparator.comparingInt(Pair::getKey))
    //         .collect(Collectors.toList());
    // IntStream.range(0, A.length)
    //     .forEach(
    //         i -> {
    //           res[0] = Math.max(res[0], lst.get(i).getKey());
    //           res[1] = Math.max(res[1], lst.get(i).getValue() - 1 - res[0]);
    //         });
    // return res[0];
  }
}
