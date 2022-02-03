package com.atul.scaler.lean.strings.periodofstring;

import static com.atul.scaler.lean.utils.O.attach;

import java.util.Arrays;

/** @author atulanand */
public class Solution {

  public int solve(String A) {
    return lastZForFirstA(A.toCharArray(), zArray(A));
  }

  private int lastZForFirstA(char[] A, int[] z) {
    if (Arrays.stream(z).filter(x -> x == 0).count() == 0) return 1;
    for (int i = 1; i < z.length; i++) {
      if (i + z[i] == z.length) {
        return i;
      }
    }
    return z[0];
  }

  private int[] zArray(String str) {
    int[] z = new int[str.length()];
    z[0] = str.length();
    int start = 0, end = 0;
    for (int i = 1; i < str.length(); i++) {
      if (z[i - start] < end - i + 1) {
        z[i] = z[i - start];
      } else {
        int j = getJ(str, i, (i > end) ? i : end + 1);
        z[i] = j - i;
        start = i;
        end = j - 1;
      }
    }
    return z;
  }

  private int getJ(String str, int of, int from) {
    int j = from;
    while (j < str.length() && str.charAt(j) == str.charAt(j - of)) j++;
    return j;
  }

  public static void main(String[] args) {
    attach();
    System.out.println(new Solution().solve("abababab"));
    System.out.println(new Solution().solve("aadabcabc"));
    System.out.println(new Solution().solve("aaaa"));
    System.out.println(new Solution().solve("abcaabcaab"));
    System.out.println(new Solution().solve("abababababb"));
  }
}
