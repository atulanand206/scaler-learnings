package com.atul.scaler.lean.binarysearch.foodpkts;

import com.atul.scaler.lean.utils.O;
import com.atul.scaler.lean.utils.S;

public class Solution {
  public int solve(int[] A, int B) {
    if (B < A.length || B > sumOf(A)) return 0;
    int s = 1, e = minOf(A);
    int ans = 0;
    while (s <= e) {
      int mid = (s + e) / 2;
      O.debug(mid + " ");
      int ofcs = isValid(A, mid);
      if (ofcs >= B) {
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return ans;
  }

  private int isValid(int[] A, int x) {
    int ofc = 0;
    for (int i : A) ofc += i / x;
    O.debug(S.string(ofc));
    return ofc;
  }

  private int minOf(int[] A) {
    int z = 0;
    for (int i : A) z = Math.min(z, i);
    return z;
  }

  private long sumOf(int[] A) {
    long z = 0;
    for (int i : A) z += i;
    return z;
  }

  public static void main(String[] args) {
    O.attach();
    //    System.out.println(new Solution().solve(new int[] {8, 7, 1, 5, 5, 10, 10, 1, 5, 3}, 17));
    long i = 7;
    for (int j = 0; j < 18; j++) {
      O.debug(String.format("%60s %d\n", Long.toBinaryString(i), i));
      i *= 7;
    }
  }
}
