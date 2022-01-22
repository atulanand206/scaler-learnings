package com.atul.scaler.lean.strings.cyclicpermutations;

import static com.atul.scaler.lean.utils.O.attach;

/** @author atulanand */
public class Solution {

  public int solve(String A, String B) {
    return countOfEquals(zArray(A + "$" + B + B, B.length()), B.length());
  }

  private int countOfEquals(int[] z, int B) {
    int cnt = 0;
    for (int i : z) if (i == B) cnt++;
    return cnt;
  }

  private int[] zArray(String str, int exclude) {
    int[] z = new int[str.length()];
    z[0] = str.length();
    int start = 0, end = 0;
    for (int i = 1; i < str.length() - exclude; i++) {
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
    System.out.println(new Solution().solve("1101111111", "1101111111"));
  }
}
