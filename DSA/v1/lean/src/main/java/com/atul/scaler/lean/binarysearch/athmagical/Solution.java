package com.atul.scaler.lean.binarysearch.athmagical;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {

  private static final int MOD = (int) 1E9 + 7;

  public int solve(int A, int B, int C) {
    long s = Math.min(B, C);
    long e = s * A;
    long mid;
    int ans = Integer.MAX_VALUE;
    while (s <= e) {
      mid = (s + e) / 2;
      long which = magical(mid, B, C);
      O.debug(S.string(mid + " " + which));
      if (which == A) {
        ans = Math.min(ans, (int) (mid % MOD));
        e = mid - 1;
      }
      if (which < A) s = mid + 1;
      else e = mid - 1;
    }
    return ans;
  }

  private long magical(long N, int B, int C) {
    return div(N, B) + div(N, C) - div(N, lcm(B, C));
  }

  private long div(long N, int x) {
    O.debug(S.string(String.format("%d/%d = %d", N, x, (N / x))));
    return N / x;
  }

  private int lcm(int A, int B) {
    return (A * B) / gcd(A, B);
  }

  private int gcd(int A, int B) {
    if (B == 0) return A;
    return gcd(B, A % B);
  }
}
