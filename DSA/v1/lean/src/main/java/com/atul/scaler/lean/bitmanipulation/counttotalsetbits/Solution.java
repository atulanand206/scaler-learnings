package com.atul.scaler.lean.bitmanipulation.counttotalsetbits;

import static com.atul.scaler.lean.utils.O.*;

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

  public static int setBits(int A) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int a = ((A + 1) / (1 << (i + 1))) * (1 << i);
      int b = Math.max(0, ((A + 1) % (1 << (i + 1))) - (1 << i));
      ans += (a % MOD + b % MOD) % MOD;
    }
    return ans;
  }

  public static int setBits2(int A) {
    long ans = 0;
    for (int i = 0; i < 32; i++) {
      if ((A & (1 << i)) > 0) {
        int x = i;
        x = x * (1 << (i - 1));
        ans = (ans + x + 1) % MOD;
        A -= 1 << i;
        ans = (ans + A) % MOD;
      }
    }
    return (int) (ans % MOD);
  }

  public static void main(String[] args) {
    attach();
    for (int i = 0; i <= 16; i++) debugN(String.format("%6s", Integer.toBinaryString(i)));
  }
}
