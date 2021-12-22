package com.atul.scaler.lean.bitmanipulation.diffbitspairwisesum;

/**
 * Problem: We define f(X, Y) as number of different corresponding bits in binary representation of
 * X and Y.
 *
 * <p>For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111,
 * respectively. The first and the third bit differ, so f(2, 7) = 2.
 *
 * <p>You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all
 * pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.
 *
 * <p>Constraints
 *
 * <p>1 <= N <= 10^5
 *
 * <p>1 <= A[i] <= 2^31 - 1
 *
 * @author atulanand
 */
public class Solution {
  public int cntBits(int[] A) {
    char[][] binaryStrings = new char[A.length][];
    int length = 0;
    for (int i = 0; i < A.length; i++) {
      binaryStrings[i] = Integer.toBinaryString(A[i]).toCharArray();
      length = Math.max(length, binaryStrings[i].length);
    }
    for (int i = 0; i < A.length; i++) {
      binaryStrings[i] =
          (of(length - binaryStrings[i].length) + Integer.toBinaryString(A[i])).toCharArray();
    }
    int[] ones = new int[length];
    int[] zeros = new int[length];
    for (int i = 0; i < A.length; i++) {
      char[] x = binaryStrings[i];
      int k = length - 1;
      for (int j = x.length - 1; j >= 0; j--) {
        int bit = getAsInt(x, j);
        if (bit == 1) ones[k]++;
        else zeros[k]++;
        k--;
      }
      while (k >= 0) {
        zeros[k--]++;
      }
    }
    return cumulativePairwiseDiffSum(ones, zeros);
  }

  private static final int MOD = (int) 1E9 + 7;

  private int cumulativePairwiseDiffSum(int[] ones, int[] zeros) {
    long res = 0;
    for (int i = 0; i < ones.length; i++) {
      long cnt = (2L * zeros[i] * ones[i]) % MOD;
      res = (res + cnt) % MOD;
    }
    return (int) res;
  }

  private int getAsInt(char[] chars, int i) {
    return chars[i] == '1' ? 1 : 0;
  }

  private String of(int length) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < length; i++) res.append("0");
    return res.toString();
  }
}
