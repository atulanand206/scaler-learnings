package com.atul.scaler.lean.binarysearch.painterpartition;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {
  private static final int MOD = (int) 1E7 + 3;

  public int paint(int A, int B, int[] C) {
    long[] ls = new long[C.length];
    for (int i = 0; i < ls.length; i++) ls[i] = C[i];

    long s = maxOf(ls) * B, e = sumOf(ls) * B;

    long ans = e;
    while (s <= e) {
      long mid = (s + e) / 2;
      if (isValid(ls, A - 1, mid, B)) {
        ans = Math.min(ans, mid);
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }
    O.debug(S.string(ans % MOD));
    return (int) (ans % MOD);
  }

  private boolean isValid(long[] A, long B, long x, int factor) {
    long z = A[0] * factor;
    int i = 1;
    while (i < A.length) {
      if (z + A[i] * factor <= x) {
        z += A[i] * factor;
      } else {
        B--;
        z = A[i] * factor;
      }
      i++;
    }
    return B >= 0;
  }

  private long sumOf(long[] A) {
    long z = 0;
    for (long i : A) z += i;
    return z;
  }

  private long maxOf(long[] A) {
    long z = 0;
    for (long i : A) z = Math.max(z, i);
    return z;
  }

  public static void main(String[] args) {
    O.attach();
    System.out.println(new Solution().paint(1, 1000000, new int[] {1000000, 1000000}));
  }
}
