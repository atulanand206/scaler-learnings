package com.atul.scaler.lean.strings.makestringspalindrome;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

/** @author atulanand */
public class Solution {

  public int solve(String A) {
    if (A.length() == 1) return 0;
    StringBuilder sb = new StringBuilder(A);
    sb.reverse();
    for (int i = A.length() - 1; i > 0; i--) {
      if (A.charAt(i) == A.charAt(0)) {
        String aSub = A.substring(1, i);
        String bSub = sb.substring(sb.length() - i, sb.length() - 1);
        O.debug(S.string(aSub));
        O.debug(S.string(bSub));
        if (aSub.equals(bSub)) return A.length() - i - 1;
      }
    }
    return A.length() - 1;
  }

  public int solve2(String A) {
    StringBuilder sb = new StringBuilder(A);
    sb.reverse();
    String zIn = sb + "$" + A;
    O.debug(S.string(zIn));
    int[] z = zArray(zIn);
    int max = 0;
    for (int i = A.length() + 1; i < zIn.length(); i++)
      if (z[i] == zIn.length() - i) max = Math.max(max, z[i]);
    return A.length() - max;
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
    O.attach();
    O.debug(S.string(new Solution().solve2("baabbbb")));
    O.debug(S.string(new Solution().solve2("babb")));
    O.debug(S.string(new Solution().solve2("abc")));
    O.debug(S.string(new Solution().solve2("bb")));
    O.debug(S.string(new Solution().solve2("banana")));
    O.debug(S.string(new Solution().solve2("hqghumeaylnlfdxfi")));
    O.debug(S.string(new Solution().solve2("wkfnqduxwfnfozvsrtkjpr")));
  }
}
