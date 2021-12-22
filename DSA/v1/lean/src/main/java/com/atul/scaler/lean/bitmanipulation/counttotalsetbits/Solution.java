package com.atul.scaler.lean.bitmanipulation.counttotalsetbits;

import java.util.Arrays;

/**
 * Problem: Given a positive integer A, the task is to count the total number of set bits in the
 * binary representation of all the numbers from 1 to A.
 *
 * <p>Return the count modulo 10^9 + 7.
 *
 * @author atulanand
 */
public class Solution {

  private static final int MOD = (int) 1E9 + 7;

  public int solve(int A) {
    int n = A;
    int MSB = 0;
    long y = countOnes(Integer.toBinaryString(A));
    while (n > 0) {
      int length = Integer.toBinaryString(n).length() - 1;
      MSB = (1 << length);
      y = (y + sumTillMSB(MSB, length)) % MOD;
      y = (y + n - MSB) % MOD;
      n = n % MSB;
    }
    return (int) y;
  }

  public int sumTillMSB(int MSB, int length) {
    int n = MSB / 2;
    long y = ((long) length * n) % MOD;
    return (int) y;
  }

  public int countOnes(String str) {
    return (int) Arrays.stream(str.split("")).filter(ch -> ch.equals("1")).count();
  }
}
