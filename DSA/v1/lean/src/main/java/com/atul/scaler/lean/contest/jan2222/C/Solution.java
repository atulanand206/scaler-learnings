package com.atul.scaler.lean.contest.jan2222.C;

import static com.atul.scaler.lean.utils.O.debug;
import static com.atul.scaler.lean.utils.S.string;

import com.atul.scaler.lean.utils.O;

/** @author atulanand */
public class Solution {

  public int solve(int[] A) {
    int small = smallest(A);
    int bitsInSmall = countOfBits(small);
    int ans = 0;
    for (int i = 0; i < A.length; i++) {
      while (countOfBits(A[i]) > bitsInSmall) {
        A[i] /= 2;
        ans++;
      }
    }
    while (!allSame(A)) {
      ans += A.length;
      for (int i = 0; i < A.length; i++) A[i] /= 2;
    }
    return ans;
  }

  private boolean allSame(int[] A) {
    for (int j : A) if (j != A[0]) return false;
    return true;
  }

  private int countOfBits(int from) {
    int cnt = 0;
    while (from > 0) {
      cnt++;
      from /= 2;
    }
    return cnt;
  }

  private int smallest(int[] A) {
    int res = A[0];
    for (int i : A) res = Math.min(res, i);
    return res;
  }

  public static void main(String[] args) {
    O.attach();
    debug(string(new Solution().solve(new int[] {1, 2, 3})));
    debug(string(new Solution().solve(new int[] {3, 1, 1, 3})));
    debug(string(new Solution().solve(new int[] {2, 2, 2})));
  }
}
