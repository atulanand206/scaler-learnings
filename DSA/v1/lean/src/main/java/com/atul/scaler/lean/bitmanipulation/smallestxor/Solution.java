package com.atul.scaler.lean.bitmanipulation.smallestxor;

/**
 * Problem: Given two integers A and B, find a number X such that A xor X is minimum possible, and
 * the number of set bits in X equals B.
 *
 * @author atulanand
 */
public class Solution {
  public int solve(int A, int B) {
    int k = 1;
    int p = A;
    while (p > 1) {
      k <<= 1;
      p >>= 1;
    }
    int z = 0;
    p = A;
    int cnt = 0;
    while (k > 0) {
      if ((p & k) > 0) {
        cnt++;
        z |= k;
      }
      k >>= 1;
      if (cnt == B) break;
    }
    k = 1;
    while (cnt < B) {
      if ((p & k) == 0) {
        z |= k;
        cnt++;
      }
      k <<= 1;
    }
    return z;
  }
}
