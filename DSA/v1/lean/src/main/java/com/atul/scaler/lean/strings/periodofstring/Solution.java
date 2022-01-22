package com.atul.scaler.lean.strings.periodofstring;

import static com.atul.scaler.lean.utils.O.attach;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

/** @author atulanand */
public class Solution {

  public int solve(String A) {
    return lastZForFirstA(A.toCharArray(), zArray(A));
  }

  private int lastZForFirstA(char[] A, int[] z) {
    int cnt = 0;
    for (int i = z.length - 1; i >= 0; i--) {
      if (A[i] == A[0]) return z[i];
    }
    return cnt;
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
    O.debug(S.string(z));
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
  }
}
