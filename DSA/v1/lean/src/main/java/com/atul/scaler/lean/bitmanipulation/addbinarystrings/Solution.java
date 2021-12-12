package com.atul.scaler.lean.bitmanipulation.addbinarystrings;

/**
 * Problem: Given two binary strings, return their sum (also a binary string).
 *
 * @author atulanand
 */
public class Solution {
  public String addBinary(String A, String B) {
    if (A.length() > B.length()) B = of(A.length() - B.length()) + B;
    if (A.length() < B.length()) A = of(B.length() - A.length()) + A;
    StringBuilder sb = new StringBuilder();
    char[] aChars = A.toCharArray();
    char[] bChars = B.toCharArray();
    int carry = 0;
    for (int i = aChars.length - 1; i >= 0; i--) {
      int x = getAsInt(aChars, i) + getAsInt(bChars, i) + carry;
      carry = x / 2;
      sb.append(x % 2);
    }
    if (carry == 1) sb.append(1);
    return sb.reverse().toString();
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
