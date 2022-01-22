package com.atul.scaler.lean.twopointers.pairsum2;

import static com.atul.scaler.lean.utils.O.*;
import static com.atul.scaler.lean.utils.S.*;

public class Solution {
  private static int MOD = (int) 1E9 + 7;

  public int solve(int[] A, int B) {
    int len = A.length - 1;
    // if ((B < A[0]) || (A[len - 2] + A[len - 1] < B)) return 0;
    int start = 0, end = len;
    long ans = 0;
    while (start < end) {
      int v1 = A[start], v2 = A[end];
      int sum = v1 + v2;
      long contribution = 0;
      if (v1 == v2 && sum == B) {
        long cnt = (end - start + 1);
        contribution = (cnt * (cnt - 1) / 2) % MOD;
        ans = (ans + contribution) % MOD;
        debug(string(v1 + " " + v2 + " " + cnt + " " + contribution + " "));
        debug(string("ans  " + ans));
        return (int) ans;
      } else {
        debugN(string(sum));
        if (sum == B) {
          long cnt1 = 1;
          while (start < len - 1 && A[start] == A[start + 1]) {
            cnt1++;
            start++;
          }
          long cnt2 = 1;
          while (end > 0 && A[end] == A[end - 1]) {
            cnt2++;
            end--;
          }
          contribution = (cnt1 * cnt2) % MOD;
          ans = (ans + contribution) % MOD;

          debug(string(v1 + " " + v2 + " " + cnt1 + " " + cnt2 + " " + contribution + " "));

          start++;
          end--;

        } else if (sum < B) {

          start++;
        } else {
          end--;
        }
        debugN(string(start + " " + end));
      }
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    attach();
    System.out.println(new Solution().solve(new int[] {1, 3, 5, 5, 10, 10}, 14));
  }
}
