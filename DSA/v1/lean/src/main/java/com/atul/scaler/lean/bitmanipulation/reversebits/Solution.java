package com.atul.scaler.lean.bitmanipulation.reversebits;

/**
 * Problem: Reverse the bits of an 32 bit unsigned integer A.
 *
 * @author atulanand
 */
public class Solution {

  public long reverse(long a) {
    long y = 0;
    int i = 0;
    while (a > 0) {
      long lsb = a & 1;
      y |= lsb;
      a >>= 1;
      y <<= 1;
      i++;
    }
    while (i < 32) {
      y |= 0;
      y <<= 1;
      i++;
    }
    y >>= 1;
    return y;
  }
}
